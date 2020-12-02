import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Carro } from '../component/carro/carro.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarroService {
  baseUrl = "http://localhost:8080/carros";
  constructor(private snackBar: MatSnackBar,
    private http: HttpClient) { }

  mostrarMensagen(msg: string): void {
    this.snackBar.open(msg, 'Fechar', {
      verticalPosition: "top",
      horizontalPosition: "right",
      duration: 3000
    })
  }


  criarNovoCarro(car: Carro): Observable<Carro> {
    return this.http.post<Carro>(this.baseUrl, car);
  }

  pegarCarros(): Observable<Carro[]> {
    return this.http.get<Carro[]>(this.baseUrl);
  }

  pegarCarroPorId(id: string): Observable<Carro> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Carro>(url);
  }

  atualizarCarro(car: Carro): Observable<Carro> {
    const url = `${this.baseUrl}/${car.id}`;
    return this.http.put<Carro>(url, car);
  }

  deletarCarro(car: Carro) {
    const url = `${this.baseUrl}/${car.id}`;
    console.log(url);
    return this.http.delete<Carro>(url);
  }
}
