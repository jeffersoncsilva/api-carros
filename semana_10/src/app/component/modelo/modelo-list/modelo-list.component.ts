import { Component, OnInit } from '@angular/core';
import { ConfirmDeleteComponent } from './../../../template/confirm-delete/confirm-delete.component';
import { ModeloService } from './../../../service/modelo.service';
import { Modelo } from './../modelo.model';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modelo-list',
  templateUrl: './modelo-list.component.html',
  styleUrls: ['./modelo-list.component.css']
})
export class ModeloListComponent implements OnInit {
  displayedColumns: string[] = ['id', 'modelo', 'fabriNome', 'action'];
  modelos = [] as any;
  constructor(
    private servico: ModeloService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.servico.pegarModelos().subscribe(mods => {
      this.modelos = mods;
    });
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
    });
  }

}
