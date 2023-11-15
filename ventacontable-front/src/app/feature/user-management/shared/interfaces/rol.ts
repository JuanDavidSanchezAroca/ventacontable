export interface Rol {
    id: number;
    nombre: string;
    descripcion: string;
  }
  
export interface DataResponseRol {
    valor: Rol[];
  }