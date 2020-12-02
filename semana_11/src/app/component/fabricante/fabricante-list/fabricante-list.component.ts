import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { ConfirmDeleteComponent } from './../../../template/confirm-delete/confirm-delete.component';
import { FabricanteService } from './../../../service/fabricante.service';
import { Fabricante } from './../fabricante.model';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { merge, of as ofasobservableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-fabricante-list',
  templateUrl: './fabricante-list.component.html',
  styleUrls: ['./fabricante-list.component.css']
})
export class FabricanteListComponent implements AfterViewInit {
  displayedColumns: string[] = ['id', 'fabricante', 'action'];
  fabricantes = [] as any;
  isLoadingResults: boolean = false;
  resultsLength = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private servico: FabricanteService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngAfterViewInit(): void {
    this.atualizarTabela();
  }

  apagarFabricante(fabi: Fabricante): void {
    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: `Deseja realmente excluir o Fabricante ${fabi.fabriNome}?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Cancelar'
        }
      }
    });

    dialogRef.afterClosed().subscribe((confimed: boolean) => {
      if (confimed) {
        this.servico.deletarFabricante(fabi).subscribe(() => {
          this.servico.mostrarMensagen("Fabricante excluido com sucesso.");
        });
        this.router.navigate(['/fabricantes']);
      }
    }, error => {
      this.isLoadingResults = false;
      this.servico.mostrarMensagen("Não foi possivel apagar o fabricante.", true);
    });

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
        this.fabricantes = data;
      });
  }
}
