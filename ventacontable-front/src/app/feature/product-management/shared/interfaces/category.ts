export interface Category {
    id: number;
    nombre: string;
    descripcion: string;
}

export interface DataResponseCategory {
    valor: Category[];
}