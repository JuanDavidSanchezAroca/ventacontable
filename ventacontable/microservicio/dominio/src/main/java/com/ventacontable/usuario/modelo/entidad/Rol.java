package com.ventacontable.usuario.modelo.entidad;

import lombok.Getter;

import java.util.List;

@Getter
public class Rol {
    private String nombre;
    private String descripcion;
    private List<Permiso> permisos;

    public Rol(String nombre,String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
