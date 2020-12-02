import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Fabricante } from '../component/fabricante/fabricante.model';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FabricanteService {
  baseUrl = "http://localhost:8080/fabricantes";
  constructor(private snackBar: MatSnackBar,
    private http: HttpClient) { }

  mostrarMensagen(msg: string): void {
    this.snackBar.open(msg, 'Fechar', {
      verticalPosition: "top",
      horizontalPosition: "right",
      duration: 3000
    })
  }


  criarNovoFabricante(fab: Fabricante): Observable<Fabricante> {
    return this.http.post<Fabricante>(this.baseUrl, fab);
  }

  pegarFabricante(): Observable<Fabricante[]> {
    return this.http.get<Fabricante[]>(this.baseUrl);
  }

  pegarFabricantePorId(id: string): Observable<Fabricante> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Fabricante>(url);
  }

  atualizarFabricante(fabi: Fabricante): Observable<Fabricante> {
    const url = `${this.baseUrl}/${fabi.id}`;
    return this.http.put<Fabricante>(url, fabi);
  }

  deletarFabricante(fabi: Fabricante) {
    const url = `${this.baseUrl}/${fabi.id}`;
    console.log(url);
    return this.http.delete<Fabricante>(url);
  }

}
