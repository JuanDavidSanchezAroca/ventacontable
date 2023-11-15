export interface Product {
    codigo: string;
    nombre: string;
    descripcion: string;
    precioMinimo: number;
    precioMaximo: number;
    precioBase: number;
    talla: string;
    color: string;
    cantidadDisponible: number;
    categorias: number[];
  }