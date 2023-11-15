export interface Category {
    id: number | undefined;
    nombre: string;
    descripcion: string;
}

export interface DataResponseCategory {
    valor: Category[];
}