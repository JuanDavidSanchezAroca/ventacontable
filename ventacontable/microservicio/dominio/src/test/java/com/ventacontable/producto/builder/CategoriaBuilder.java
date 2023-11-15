package com.ventacontable.producto.builder;


import com.ventacontable.categoria.modelo.entidad.Categoria;

public class CategoriaBuilder {
    private String nombre;
    private String descripcion;

    public CategoriaBuilder() {
        this.nombre = "categoria_prueba";
        this.descripcion = "categoria_prueba_descripcion";
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
        return new Categoria(nombre, descripcion);
    }
}
