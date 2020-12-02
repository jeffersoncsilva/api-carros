import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { CarroFormComponent } from './component/carro/carro-form/carro-form.component';
import { CarroListComponent } from './component/carro/carro-list/carro-list.component';
import { FabricanteFormComponent } from './component/fabricante/fabricante-form/fabricante-form.component';
import { FabricanteListComponent } from './component/fabricante/fabricante-list/fabricante-list.component';
import { ModeloFormComponent } from './component/modelo/modelo-form/modelo-form.component';
import { ModeloListComponent } from './component/modelo/modelo-list/modelo-list.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'carros', component: CarroListComponent },
  { path: 'carros/form', component: CarroFormComponent },
  { path: 'fabricantes', component: FabricanteListComponent },
  { path: 'fabricantes/form', component: FabricanteFormComponent },
  { path: 'modelos', component: ModeloListComponent },
  { path: 'modelos/form', component: ModeloFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
