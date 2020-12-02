import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Modelo } from '../component/modelo/modelo.model';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ModeloService {
  baseUrl = "http://localhost:8080/modelos";
  constructor(private snackBar: MatSnackBar,
    private http: HttpClient) { }

  mostrarMensagen(msg: string): void {
    this.snackBar.open(msg, 'Fechar', {
      verticalPosition: "top",
      horizontalPosition: "right",
      duration: 3000
    })
  }

  criarNovoModelo(model: Modelo): Observable<Modelo> {
    return this.http.post<Modelo>(this.baseUrl, model);
  }

  pegarModelos(): Observable<Modelo[]> {
    return this.http.get<Modelo[]>(this.baseUrl);
  }

  pegarModeloPorId(id: string): Observable<Modelo> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Modelo>(url);
  }

  atualizarModelo(model: Modelo): Observable<Modelo> {
    const url = `${this.baseUrl}/${model.id}`;
    console.log(url);
    return this.http.put<Modelo>(url, model);
  }

  deletarModelo(model: Modelo) {
    const url = `${this.baseUrl}/${model.id}`;
    return this.http.delete<Modelo>(url);
  }

}
