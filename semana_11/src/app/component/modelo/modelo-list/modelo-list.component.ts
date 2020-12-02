import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { ConfirmDeleteComponent } from './../../../template/confirm-delete/confirm-delete.component';
import { ModeloService } from './../../../service/modelo.service';
import { Modelo } from './../modelo.model';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { merge, of as ofasobservableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-modelo-list',
  templateUrl: './modelo-list.component.html',
  styleUrls: ['./modelo-list.component.css']
})
export class ModeloListComponent implements AfterViewInit {
  displayedColumns: string[] = ['id', 'modelo', 'fabriNome', 'action'];
  modelos = [] as any;
  isLoadingResults = false;
  resultsLength = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private servico: ModeloService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngAfterViewInit(): void {
    this.atualizarTabela();
  }

  apagarModelo(mod: Modelo): void {
    console.log(mod);
    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: `Deseja realmente excluir o Modelo ${mod.nomeModelo}?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Cancelar'
        }
      }
    });

    dialogRef.afterClosed().subscribe((confimed: boolean) => {
      if (confimed) {
        this.servico.deletarModelo(mod).subscribe(() => {
          this.servico.mostrarMensagen("Modelo excluido com sucesso.");
        })
        this.router.navigate(['/modelos']);
        location.reload();
      }
    },
      erro => {
        this.isLoadingResults = false;
        this.servico.mostrarMensagen("Não foi possivel atualizar fabricante.", true);
      });
  }

  atualizarTabela(): void {
    console.log("atualizar tabela chamado.");
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);
    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          console.log("buscando dados no servico.");
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
        this.modelos = data;
        console.log(data);
      });
  }

}
