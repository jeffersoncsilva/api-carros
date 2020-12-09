import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from '../component/users/user.model';
import { UserPage } from './../component/users/user-list/user-page';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    baseUrl = "http://localhost:8080/users";

    constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

    mostrarMensagen(msg: string, error: boolean = false): void {
        this.snackBar.open(msg, 'Fechar', {
            verticalPosition: "top",
            horizontalPosition: "right",
            duration: 3000,
            panelClass: error ? ['msg-error'] : ['msg-success']
        })
    }

    criarNovoUsuario(usuario: User): Observable<User> {
        return this.http.post<User>(this.baseUrl, usuario);
    }

    pegarUsuario(): Observable<User[]> {
        return this.http.get<User[]>(this.baseUrl);
    }

    pegarUsuarioPorId(id: string): Observable<User> {
        const url = `${this.baseUrl}/${id}`;
        return this.http.get<User>(url);
    }

    atualizarUsuario(usuario: User): Observable<User> {
        const url = `${this.baseUrl}/${usuario.idUsuario}`;
        return this.http.put<User>(url, usuario);
    }

    deletarUsuario(usuario: User) {
        const url = `${this.baseUrl}/${usuario.idUsuario}`;
        console.log(url);
        return this.http.delete<User>(url);
    }

    readTable(size: number, page: number): Observable<UserPage> {
        const url = `${this.baseUrl}/pages`
        return this.http.get<UserPage>(url, {
            params: new HttpParams()
                .set('page', page.toString())
                .set('size', size.toString())
        });
    }

}