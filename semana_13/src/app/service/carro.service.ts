import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Carro } from '../component/carro/carro.model';
import { Observable } from 'rxjs';
import { CarroPage } from './../component/carro/carro-list/carro-page';

@Injectable({
  providedIn: 'root'
})
export class CarroService {
  baseUrl = "http://localhost:8080/carros";
  constructor(private snackBar: MatSnackBar,
    private http: HttpClient) { }

  mostrarMensagen(msg: string, error: boolean = false): void {
    this.snackBar.open(msg, 'Fechar', {
      verticalPosition: "top",
      horizontalPosition: "right",
      duration: 3000,
      panelClass: error ? ['msg-error'] : ['msg-success']
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

  readTable(size: number, page: number): Observable<CarroPage> {
    const url = `${this.baseUrl}/paginas`
    return this.http.get<CarroPage>(url, {
      params: new HttpParams()
        .set('page', page.toString())
        .set('size', size.toString())
    });
  }
}
