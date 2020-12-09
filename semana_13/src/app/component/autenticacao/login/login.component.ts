import { Component, OnInit } from '@angular/core';
import { User } from './../../users/user.model';
import { Router } from '@angular/router';
import { AtenticacaoService } from './../../../service/autenticacao.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario: User = {
    nomeUsuario: "",
    login: "",
    dtNascimento: "",
    senha: "",
    nivel: 0
  }

  constructor(
    private servico: AtenticacaoService,
    private route: Router
  ) { }

  ngOnInit(): void { }

  onSubmit(): void {

    console.log(this.usuario);

    this.servico.login(this.usuario).subscribe(usuario => {
      if (usuario.idUsuario != null && usuario.idUsuario > 0) {
        window.localStorage.setItem('token', usuario.idUsuario?.toString() + usuario.login);
        window.localStorage.setItem('nome', usuario.nomeUsuario);
        window.localStorage.setItem('login', usuario.login);
        this.servico.showMessage(usuario.nomeUsuario + " seja bem vindo(a)!");
        this.route.navigate(['/']);
      } else {
        this.servico.showMessage("Usuário ou Senha incorreto", true)
      }
      // this.router.navigate(['/usuarios']);
    },
      err => this.servico.showMessage("Erro de comunicação!!", true)
    )

  }

}
