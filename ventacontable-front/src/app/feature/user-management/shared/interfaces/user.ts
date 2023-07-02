export interface Usuario {
    correo: string;
}

export interface Persona {
    identificacion: string;
    nombre: string;
    apellido: string;
    fechaNacimiento: string;
    tipoDocumento: string;
    telefono: string;
    genero: string;
    usuario: Usuario;
    direccion: string;
    rol: number;
}