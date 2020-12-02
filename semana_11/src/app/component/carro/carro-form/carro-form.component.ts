import { Component, OnInit } from '@angular/core';
import { Carro } from './../carro.model';
import { Modelo } from './../../modelo/modelo.model';
import { CarroService } from './../../../service/carro.service';
import { ModeloService } from './../../../service/modelo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carro-form',
  templateUrl: './carro-form.component.html',
  styleUrls: ['./carro-form.component.css']
})
export class CarroFormComponent implements OnInit {

  tituloDaPagina = "Novo Carro";
  isLoadingResults = false;
  carro: Carro = {
    placa: "",
    cor: "",
    modelo: {
      nomeModelo: "",
      fabricante: { fabriNome: "" }
    }
  }
  modelos!: Modelo[];

  tipoCarro = ["PIC_UP", "SEDAN", "HATCH"];


  constructor(private carroServico: CarroService,
    private modeloServico: ModeloService,
    private router: Router) { }

  ngOnInit(): void {
    this.modeloServico.pegarModelos().subscribe(mods => {
      this.modelos = mods;
    });
  }

  salvarCarro(): void {
    console.log(this.carro);
    this.carroServico.criarNovoCarro(this.carro).subscribe(() => {
      this.carroServico.mostrarMensagen("Carro inserido com sucesso!");
      this.router.navigate(['/carros']);
    },
      erro => {
        this.isLoadingResults = false;
        this.carroServico.mostrarMensagen("Não foi possivel atualizar fabricante.", true);
      });
  }

}
