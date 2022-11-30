package com.ventacontable.producto.builder;


import com.ventacontable.producto.modelo.entidad.Categoria;

public class CategoriaBuilder {
    private int id;
    private String nombre;
    private String descripcion;

    public CategoriaBuilder() {
        this.id = 1;
        this.nombre = "categoria_prueba";
        this.descripcion = "categoria_prueba_descripcion";
    }

    public CategoriaBuilder conId(Integer id) {
        this.id = id;
        return this;
    }

    public CategoriaBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CategoriaBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Categoria build() {
        return new Categoria(id, nombre, descripcion);
    }
}
