import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Carro } from './../carro.model';
import { CarroService } from './../../../service/carro.service';
import { Modelo } from './../../modelo/modelo.model';
import { ModeloService } from './../../../service/modelo.service';

@Component({
  selector: 'app-carro-update',
  templateUrl: './../carro-form/carro-form.component.html',
  styleUrls: ['./carro-update.component.css']
})
export class CarroUpdateComponent implements OnInit {
  isLoadingResults = false;
  tituloDaPagina = "Editar Carro";

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

  constructor(
    private carroServico: CarroService,
    private modeloServico: ModeloService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.carroServico.pegarCarroPorId(id!).subscribe(car => {
      this.carro = car;
    });
    this.modeloServico.pegarModelos().subscribe(mods => {
      this.modelos = mods;
    });
  }


  salvarCarro(): void {
    this.carroServico.atualizarCarro(this.carro).subscribe(() => {
      this.carroServico.mostrarMensagen("Carro alterado com sucesso");
      this.router.navigate(['/carros'])
    }, erro => {
      this.isLoadingResults = false;
      this.carroServico.mostrarMensagen("Não foi possivel atualizar fabricante.", true);
    });
  }

}
