import { Modelo } from './../modelo/modelo.model';
export interface Carro {
    id?: number;
    ano?: number;
    cor: string;
    placa: string;
    tipo?: number;
    modelo: Modelo;
}
