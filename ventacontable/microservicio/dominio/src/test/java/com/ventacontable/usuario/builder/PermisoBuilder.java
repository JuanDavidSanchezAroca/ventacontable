package com.ventacontable.usuario.builder;

import com.ventacontable.usuario.modelo.Permiso;

public class PermisoBuilder {
    private Integer id;
    private String nombre;

    public PermisoBuilder(){
        this.id = 1;
        this.nombre = "permiso_prueba";
    }

    public PermisoBuilder conId(Integer id){
        this.id = id;
        return this;
    }

    public PermisoBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public Permiso build(){
        return new Permiso(nombre);
    }
}
