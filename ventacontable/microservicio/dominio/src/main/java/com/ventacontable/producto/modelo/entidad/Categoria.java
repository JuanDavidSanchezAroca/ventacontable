package com.ventacontable.producto.modelo.entidad;

import lombok.Getter;
import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;


@Getter
public class Categoria {
    private static final String SE_DEBE_INGRESAR_NOMBRE_CATEGORIA = "Se debe ingresar el nombre de la categoria";

    private int idCategoria;
    private String nombre;
    private String descripcion;

    public Categoria(int idCategoria, String nombre, String descripcion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE_CATEGORIA);
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Categoria(String nombre){
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE_CATEGORIA);
        this.idCategoria=idCategoria;
        this.nombre=nombre;
    }
}
