import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Fabricante } from './../fabricante.model';
import { FabricanteService } from './../../../service/fabricante.service';

@Component({
  selector: 'app-fabricante-update',
  templateUrl: './fabricante-update.component.html',
  styleUrls: ['./fabricante-update.component.css']
})
export class FabricanteUpdateComponent implements OnInit {
  fabri!: Fabricante;
  tituloPagina = "Alterarando dados fabricante";

  constructor(
    private servico: FabricanteService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.servico.pegarFabricantePorId(id!).subscribe(fab => {
      this.fabri = fab;
    })
  }

  salvarFabricante(): void {

    this.servico.atualizarFabricante(this.fabri!).subscribe(() => {
      this.servico.mostrarMensagen("Fabricante alterado com sucesso");
      this.router.navigate(['/fabricantes'])
    });
  }

}
