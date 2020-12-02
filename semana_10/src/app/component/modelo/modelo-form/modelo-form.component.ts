import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Modelo } from './../modelo.model';
import { Fabricante } from './../../fabricante/fabricante.model';
import { ModeloService } from './../../../service/modelo.service';
import { FabricanteService } from './../../../service/fabricante.service';

@Component({
  selector: 'app-modelo-form',
  templateUrl: './modelo-form.component.html',
  styleUrls: ['./modelo-form.component.css']
})
export class ModeloFormComponent implements OnInit {
  fabricantes!: Fabricante[];
  modelo: Modelo = {
    nomeModelo: "",
    fabricante: { fabriNome: "" },
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
  }

  salvarModelo(): void {
    console.log(this.modelo);
    this.modeloService.criarNovoModelo(this.modelo).subscribe(() => {
      this.modeloService.mostrarMensagen("Modelo inserido com sucesso.");
      this.router.navigate(['/modelos']);
    })
  }

}
