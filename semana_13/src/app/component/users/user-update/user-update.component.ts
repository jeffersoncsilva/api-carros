import { Component, OnInit } from '@angular/core';
import { User } from './../user.model';
import { UserService } from './../../../service/user.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-user-update',
  templateUrl: './../user-form/user-form.component.html',
  styleUrls: ['./../user-form/user-form.component.css']
})
export class UserUpdateComponent implements OnInit {
  tituloDaPagina = "Atualizando de usuário";
  usuario!: User;
  isLoadingResults = false;
  tipoUsuarios = ["Administrador", "Gestor", "Comum"]
  hide = true;
  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.userService.pegarUsuarioPorId(id!).subscribe(user => {
      this.usuario = user;
    });
  }

  salvarUsuario() {
    console.log(this.usuario);
    this.userService.criarNovoUsuario(this.usuario).subscribe(() => {
      this.userService.mostrarMensagen("Usuário alterado com sucesso!");
      this.router.navigate(['/users']);
    }, erro => {
      this.isLoadingResults = false;
      this.userService.mostrarMensagen("Não foi possivel atualizar usuário.", true);
    });
  }

}
