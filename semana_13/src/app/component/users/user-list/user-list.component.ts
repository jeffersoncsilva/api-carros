import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { ConfirmDeleteComponent } from './../../../template/confirm-delete/confirm-delete.component';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { User } from './../user.model';
import { UserService } from './../../../service/user.service';
import { merge, of as ofasobservableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements AfterViewInit {
  displayedColumns: string[] = ['nome', 'nivel', 'action'];
  usuarios = [] as any;
  isLoadingResults: boolean = false;
  resultsLength = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private servico: UserService,
    private dialog: MatDialog,
    private router: Router
  ) { }

  ngAfterViewInit(): void {
    this.atualizarTabela();
  }

  apagarUsuario(usuario: User): void {
    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: `Deseja realmente excluir o usuário ${usuario.nomeUsuario}?`,
        buttonText: {
          ok: 'Excluir',
          cancel: 'Cancelar'
        }
      }
    });
    dialogRef.afterClosed().subscribe((confimed: boolean) => {
      if (confimed) {
        this.servico.deletarUsuario(usuario).subscribe(() => {
          this.servico.mostrarMensagen("Usuário excluido com sucesso.");
          //this.router.navigate(['/users']);
          this.atualizarTabela();
        });
      }
    }, error => {
      this.isLoadingResults = false;
      this.servico.mostrarMensagen("Não foi possivel apagar o usuário.", true);
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
        console.log(data);
        this.usuarios = data;
      });
  }
}
