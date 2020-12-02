import { Component, OnInit } from '@angular/core';
import { ConfirmDeleteComponent } from './../../../template/confirm-delete/confirm-delete.component';
import { CarroService } from './../../../service/carro.service';
import { Carro } from './../carro.model';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carro-list',
  templateUrl: './carro-list.component.html',
  styleUrls: ['./carro-list.component.css']
})
export class CarroListComponent implements OnInit {
  displayedColumns: string[] = ['id', 'modelo', 'fabriNome', 'ano', 'cor', 'action'];
  carros = [] as any;
  constructor(
    private servico: CarroService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.servico.pegarCarros().subscribe(cars => {
      this.carros = cars;
    });
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
    });
    this.router.navigate(['/carros']);
  }


}
