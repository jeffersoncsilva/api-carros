import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Modelo } from './../modelo.model';
import { Fabricante } from './../../fabricante/fabricante.model';
import { ModeloService } from './../../../service/modelo.service';
import { FabricanteService } from './../../../service/fabricante.service';

@Component({
  selector: 'app-modelo-update',
  templateUrl: './../modelo-form/modelo-form.component.html',
  styleUrls: ['./modelo-update.component.css']
})
export class ModeloUpdateComponent implements OnInit {
  isLoadingResults = false;
  tituloDaPagina = "Editar Modelo";

  fabricantes!: Fabricante[];
  modelo: Modelo = {
    fabricante: { fabriNome: "" },
    nomeModelo: "",
  }


  constructor(
    private fabricanteServico: FabricanteService,
    private modeloService: ModeloService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.fabricanteServico.pegarFabricante().subscribe(fabs => {
      this.fabricantes = fabs;
    });
    const id = this.route.snapshot.paramMap.get('id');
    this.modeloService.pegarModeloPorId(id!).subscribe(mod => {
      this.modelo = mod;
    });
  }

  salvarModelo(): void {
    console.log(this.modelo);
    this.modeloService.atualizarModelo(this.modelo).subscribe(() => {
      this.modeloService.mostrarMensagen("Modelo alterado com sucesso");
      this.router.navigate(['/modelos']);
    }, erro => {
      this.isLoadingResults = false;
      this.modeloService.mostrarMensagen("Não foi possivel atualizar fabricante.", true);
    });
  }


}
