import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Fabricante } from './../fabricante.model';
import { FabricanteService } from './../../../service/fabricante.service';

@Component({
  selector: 'app-fabricante-update',
  templateUrl: './../fabricante-form/fabricante-form.component.html',
  styleUrls: ['./fabricante-update.component.css']
})
export class FabricanteUpdateComponent implements OnInit {

  isLoadingResults = false;
  fabricante: Fabricante = {
    fabriNome: "",
  };
  tituloDaPagina = "Alterarando dados fabricante";

  constructor(
    private servico: FabricanteService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.servico.pegarFabricantePorId(id!).subscribe(fab => {
      this.fabricante = fab;
    })
  }

  salvarFabricante(): void {
    this.isLoadingResults = true;
    this.servico.atualizarFabricante(this.fabricante).subscribe(() => {
      this.servico.mostrarMensagen("Fabricante alterado com sucesso");
      this.isLoadingResults = false;
      this.router.navigate(['/fabricantes'])
    },
      erro => {
        this.isLoadingResults = false;
        this.servico.mostrarMensagen("Não foi possivel atualizar fabricante.", true);
      });
  }

}
