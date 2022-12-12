package com.ventacontable.usuario.modelo;

import lombok.Getter;
import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;
import static com.ventacontable.dominio.ValidadorArgumento.validarNoVacio;


@Getter
public class Permiso {
    private static final String NOMBRE_REQUERIDO = "El nombre es requerido";
    private static final String NOMBRE_INVALIDO = "Debe ingresar un valor en el nombre";
    private static final String ID_REQUERIDO = "El id es requerido";
    private Integer id;
    private String nombre;

    public Permiso(String nombre){
        validarObligatorio(nombre,NOMBRE_REQUERIDO);
        validarNoVacio(nombre,NOMBRE_INVALIDO);
        this.nombre = nombre;
    }

    public Permiso(String nombre, Integer id){
        validarObligatorio(nombre,NOMBRE_REQUERIDO);
        validarNoVacio(nombre,NOMBRE_INVALIDO);
        validarObligatorio(id,ID_REQUERIDO);
        this.id = id;
        this.nombre = nombre;
    }

}
