import { Component, OnInit } from '@angular/core';
import { ConfirmDeleteComponent } from './../../../template/confirm-delete/confirm-delete.component';
import { FabricanteService } from './../../../service/fabricante.service';
import { Fabricante } from './../fabricante.model';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fabricante-list',
  templateUrl: './fabricante-list.component.html',
  styleUrls: ['./fabricante-list.component.css']
})
export class FabricanteListComponent implements OnInit {
  displayedColumns: string[] = ['id', 'fabricante', 'action'];
  fabricantes = [] as any;

  constructor(
    private servico: FabricanteService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.servico.pegarFabricante().subscribe(bibs => {
      this.fabricantes = bibs;
      console.log(bibs);
    });
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
        })
      }
    });
    this.router.navigate(['/fabricantes']);

  }

}
