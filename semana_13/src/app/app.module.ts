import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarroListComponent } from './component/carro/carro-list/carro-list.component';
import { CarroFormComponent } from './component/carro/carro-form/carro-form.component';
import { CarroUpdateComponent } from './component/carro/carro-update/carro-update.component';
import { ConfirmDeleteComponent } from './template/confirm-delete/confirm-delete.component';
import { FabricanteListComponent } from './component/fabricante/fabricante-list/fabricante-list.component';
import { FabricanteFormComponent } from './component/fabricante/fabricante-form/fabricante-form.component';
import { FabricanteUpdateComponent } from './component/fabricante/fabricante-update/fabricante-update.component';
import { FooterComponent } from './template/footer/footer.component';
import { HeaderComponent } from './template/header/header.component';
import { HomeComponent } from './component/home/home.component';
import { ModeloListComponent } from './component/modelo/modelo-list/modelo-list.component';
import { ModeloFormComponent } from './component/modelo/modelo-form/modelo-form.component';
import { ModeloUpdateComponent } from './component/modelo/modelo-update/modelo-update.component';
import { NavComponent } from './template/nav/nav.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon'
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatListModule } from '@angular/material/list';
import { MatNativeDateModule } from '@angular/material/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSelectModule } from '@angular/material/select';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { NgModule } from '@angular/core';
import { UserFormComponent } from './component/users/user-form/user-form.component';
import { UserListComponent } from './component/users/user-list/user-list.component';
import { UserUpdateComponent } from './component/users/user-update/user-update.component';
import { CadastroComponent } from './component/autenticacao/cadastro/cadastro.component';
import { LoginComponent } from './component/autenticacao/login/login.component';
import { MainComponent } from './component/autenticacao/main/main.component';

@NgModule({
  declarations: [
    AppComponent,
    FabricanteListComponent,
    FabricanteFormComponent,
    ModeloListComponent,
    ModeloFormComponent,
    CarroListComponent,
    CarroFormComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    HomeComponent,
    ModeloUpdateComponent,
    FabricanteUpdateComponent,
    CarroUpdateComponent,
    ConfirmDeleteComponent,
    UserFormComponent,
    UserListComponent,
    UserUpdateComponent,
    CadastroComponent,
    LoginComponent,
    MainComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatCardModule,
    MatDatepickerModule,
    MatDialogModule,
    MatInputModule,
    MatIconModule,
    MatFormFieldModule,
    MatListModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatTableModule,
    MatToolbarModule,
    MatSidenavModule,
    MatSelectModule,
    MatSnackBarModule,
    MatSortModule,
    MatAutocompleteModule,
    MatProgressSpinnerModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
