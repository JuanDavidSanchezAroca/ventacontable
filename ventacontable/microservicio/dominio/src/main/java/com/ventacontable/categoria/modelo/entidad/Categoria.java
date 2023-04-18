package com.ventacontable.categoria.modelo.entidad;

import lombok.Getter;
import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;


@Getter
public class Categoria {
    private static final String SE_DEBE_INGRESAR_NOMBRE_CATEGORIA = "Se debe ingresar el nombre de la categoria";
    private static final String SE_DEBE_INGRESAR_DESCRIPCION = "Campo descripcion es requerida";

    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE_CATEGORIA);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_DESCRIPCION);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

}
