import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { ConfirmDeleteComponent } from './../../../template/confirm-delete/confirm-delete.component';
import { CarroService } from './../../../service/carro.service';
import { Carro } from './../carro.model';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { merge, of as ofasobservableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-carro-list',
  templateUrl: './carro-list.component.html',
  styleUrls: ['./carro-list.component.css']
})
export class CarroListComponent implements AfterViewInit {
  isLoadingResults = false;
  displayedColumns: string[] = ['id', 'modelo', 'fabriNome', 'ano', 'cor', 'action'];
  carros = [] as any;
  resultsLength = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private servico: CarroService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngAfterViewInit(): void {
    this.atualizarTabela();
  }

  apagarCarro(car: Carro): void {
    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: `Deseja realmente excluir o Carro ${car.toString()}?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Cancelar'
        }
      }
    });

    dialogRef.afterClosed().subscribe((confimed: boolean) => {
      if (confimed) {
        this.servico.deletarCarro(car).subscribe(() => {
          this.servico.mostrarMensagen("Carro excluido com sucesso.");
        })
      }
    }, erro => {
      this.isLoadingResults = false;
      this.servico.mostrarMensagen("Não foi possivel atualizar fabricante.", true);
    });
    this.router.navigate(['/carros']);
  }

  atualizarTabela(): void {
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);
    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          return this.servico!.readTable(this.paginator.pageSize, this.paginator.pageIndex);
        }),
        map(page => {
          this.isLoadingResults = false;
          this.resultsLength = page.totalElements;
          return page.content;
        }),
        catchError(err => {
          this.isLoadingResults = false;
          return ofasobservableOf([]);
        })
      ).subscribe(data => {
        this.carros = data;
      });
  }
}
