package com.ventacontable.usuario.modelo;

import lombok.Getter;

import java.util.List;

@Getter
public class Rol {
    private String nombre;
    private String descripcion;
    private List<Permiso> permisos;
}
