import { Fabricante } from './../fabricante/fabricante.model';

export interface Modelo {
    id?: number;
    nomeModelo: string;
    fabricante?: Fabricante;
}