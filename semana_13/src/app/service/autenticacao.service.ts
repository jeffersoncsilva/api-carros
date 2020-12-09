import { MatSnackBar } from '@angular/material/snack-bar';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './../component/users/user.model';

@Injectable({
    providedIn: 'root'
})
export class AtenticacaoService {
    baseUrl = "http://localhost:8080/autentica";


    constructor(
        private snackBar: MatSnackBar,
        private http: HttpClient
    ) { }

    showMessage(msg: string, isError: boolean = false): void {
        this.snackBar.open(msg, 'Fechar', {
            verticalPosition: "top",
            horizontalPosition: "right",
            duration: 3000,
            panelClass: isError ? ['msg-error'] : ['msg-success']
        })
    }

    login(usuario: User): Observable<User> {
        console.log('login service: ' + usuario);
        return this.http.post<User>(this.baseUrl, usuario);
    }



}
