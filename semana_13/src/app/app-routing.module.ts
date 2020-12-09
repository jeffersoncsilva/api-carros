import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './component/home/home.component';
import { CarroFormComponent } from './component/carro/carro-form/carro-form.component';
import { CarroListComponent } from './component/carro/carro-list/carro-list.component';
import { FabricanteFormComponent } from './component/fabricante/fabricante-form/fabricante-form.component';
import { FabricanteListComponent } from './component/fabricante/fabricante-list/fabricante-list.component';
import { FabricanteUpdateComponent } from './component/fabricante/fabricante-update/fabricante-update.component';
import { ModeloFormComponent } from './component/modelo/modelo-form/modelo-form.component';
import { ModeloListComponent } from './component/modelo/modelo-list/modelo-list.component';
import { ModeloUpdateComponent } from './component/modelo/modelo-update/modelo-update.component';
import { CarroUpdateComponent } from './component/carro/carro-update/carro-update.component';
import { UserListComponent } from './component/users/user-list/user-list.component';
import { UserUpdateComponent } from './component/users/user-update/user-update.component';
import { UserFormComponent } from './component/users/user-form/user-form.component';
import { GuardGuard } from './autenticacao/guard.guard';
import { MainComponent } from './component/autenticacao/main/main.component';
import { LoginComponent } from './component/autenticacao/login/login.component';
import { CadastroComponent } from './component/autenticacao/cadastro/cadastro.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent,
    children: [
      { path: 'carros', component: CarroListComponent },
      { path: 'carros/form', component: CarroFormComponent },
      { path: 'carros/update/:id', component: CarroUpdateComponent },
      { path: 'fabricantes', component: FabricanteListComponent },
      { path: 'fabricantes/form', component: FabricanteFormComponent },
      { path: 'fabricantes/update/:id', component: FabricanteUpdateComponent },
      { path: 'modelos', component: ModeloListComponent },
      { path: 'modelos/form', component: ModeloFormComponent },
      { path: 'modelos/update/:id', component: ModeloUpdateComponent },
      { path: 'users', component: UserListComponent },
      { path: 'users/update/:id', component: UserUpdateComponent },
      { path: 'users/form', component: UserFormComponent }
    ],
    canActivate: [GuardGuard]
  },
  {
    path: "",
    component: MainComponent,
    children: [
      { path: "", redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginComponent },
      { path: 'cadastro', component: CadastroComponent }
    ]
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
