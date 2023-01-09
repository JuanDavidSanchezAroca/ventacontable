package com.ventacontable.usuario.modelo;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Persona {
    private String identificacion;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private TipoDocumento tipoDocumento;
    private String telefono;
    private Genero genero;
    private String direccion;
    private Usuario usuario;
    private Rol rol;
}
