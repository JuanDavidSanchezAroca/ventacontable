package com.ventacontable.producto.modelo.entidad;

import lombok.Getter;



import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;
import static com.ventacontable.dominio.ValidadorArgumento.validarPositivo;
import static com.ventacontable.dominio.ValidadorArgumento.validarMenor;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_NOMBRE_PRODUCTO = "Se debe ingresar el nombre del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_MINIMO = "Se debe ingresar el valor minimo del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_MAXIMO = "Se debe ingresar el valor maximo del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_BASE = "Se debe ingresar el valor base del producto";
    private static final String SE_DEBE_INGRESAR_VALORES_POSITIVOS= "Se deben ingresar valores positivos";
    private static final String SE_DEBE_INGRESAR_UN_VALOR_MENOR_AL_MAXIMO = "El valor minimo debe ser menor al valor maximo";
    private static final String SE_DEBE_INGRESAR_BASE_MENOR_PRECIO_MINIMO= "El valor de la base debe ser menor al precio mínimo";

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precioMinimo;
    private double precioMaximo;
    private double precioBase;


    public Producto(int idProducto, String nombre, String descripcion,
                    double precioMinimo, double precioMaximo,
                    double precioBase) {
        validarObligatorio(nombre,SE_DEBE_INGRESAR_NOMBRE_PRODUCTO);
        validarObligatorio(precioMinimo,SE_DEBE_INGRESAR_EL_VALOR_MINIMO);
        validarObligatorio(precioMaximo,SE_DEBE_INGRESAR_EL_VALOR_MAXIMO);
        validarObligatorio(precioBase,SE_DEBE_INGRESAR_EL_VALOR_BASE);
        validarPositivo(precioMinimo,SE_DEBE_INGRESAR_VALORES_POSITIVOS);
        validarPositivo(precioMaximo,SE_DEBE_INGRESAR_VALORES_POSITIVOS);
        validarPositivo(precioBase,SE_DEBE_INGRESAR_VALORES_POSITIVOS);
        validarMenor(precioMinimo,precioMaximo,SE_DEBE_INGRESAR_UN_VALOR_MENOR_AL_MAXIMO);
        validarMenor(precioBase,precioMinimo,SE_DEBE_INGRESAR_BASE_MENOR_PRECIO_MINIMO);
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
        this.precioBase = precioBase;
    }
}
