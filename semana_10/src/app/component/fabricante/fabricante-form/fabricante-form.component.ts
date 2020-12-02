import { Component, OnInit } from '@angular/core';
import { Fabricante } from './../fabricante.model';
import { FabricanteService } from '../../../service/fabricante.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fabricante-form',
  templateUrl: './fabricante-form.component.html',
  styleUrls: ['./fabricante-form.component.css']
})
export class FabricanteFormComponent implements OnInit {

  fabricante: Fabricante = {
    fabriNome: "",
  };

  tituloDaPagina = "Cadastro novo fabricante.";

  constructor(private fabService: FabricanteService, private router: Router) { }

  ngOnInit(): void { }

  salvarFabricante(): void {
    this.fabService.criarNovoFabricante(this.fabricante).subscribe(() => {
      this.fabService.mostrarMensagen("Fabricante salvo com sucesso!");
      this.router.navigate(['/fabricantes']);
    });
  }


}
