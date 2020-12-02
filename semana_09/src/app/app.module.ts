import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FabricanteListComponent } from './component/fabricante/fabricante-list/fabricante-list.component';
import { FabricanteFormComponent } from './component/fabricante/fabricante-form/fabricante-form.component';
import { ModeloListComponent } from './component/modelo/modelo-list/modelo-list.component';
import { ModeloFormComponent } from './component/modelo/modelo-form/modelo-form.component';
import { CarroListComponent } from './component/carro/carro-list/carro-list.component';
import { CarroFormComponent } from './component/carro/carro-form/carro-form.component';
import { FooterComponent } from './view/template/footer/footer.component';
import { HeaderComponent } from './view/template/header/header.component';
import { NavComponent } from './view/template/nav/nav.component';
import { HomeComponent } from './component/home/home.component';

import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';

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
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
