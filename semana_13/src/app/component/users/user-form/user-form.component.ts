import { Component, OnInit } from '@angular/core';
import { User } from './../user.model';
import { UserService } from './../../../service/user.service';
import { Router } from '@angular/router';
import * as moment from 'moment';
import { ModeloFormComponent } from '../../modelo/modelo-form/modelo-form.component';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  tituloDaPagina = "Cadastro de novo usuário";
  hide = true;
  usuario: User = {
    nomeUsuario: "",
    login: "",
    senha: "",
    dtNascimento: "",
    nivel: 0
  };

  isLoadingResults = false;

  tipoUsuarios = ["ADMIN", "GESTOR", "COMUM"]

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void { }

  salvarUsuario() {
    /*
    let newDate: moment.Moment = moment.utc(user.dtNascimento);
    this.usuario.dtNascimento = newDate.format("YYY-MM-DD") + "T00:00:00"
    */
    //var newData: moment.Moment = moment.utc(this.usuario.dtNascimento);
    let newDate: moment.Moment = moment.utc(this.usuario.dtNascimento).local();
    this.usuario.dtNascimento = newDate.format("YYYY-MM-DD") + "T00:00:00";

    console.log(this.usuario);

    this.userService.criarNovoUsuario(this.usuario).subscribe(() => {
      this.userService.mostrarMensagen("Usuário salvo com sucesso!");
      this.router.navigate(['/users']);
    }, erro => {
      this.isLoadingResults = false;
      this.userService.mostrarMensagen("Não foi possivel criar usuário.", true);
    });
  }

}
