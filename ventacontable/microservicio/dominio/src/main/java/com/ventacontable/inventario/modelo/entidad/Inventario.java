package com.ventacontable.inventario.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;
import static com.ventacontable.dominio.ValidadorArgumento.validarPositivo;
import static com.ventacontable.dominio.ValidadorArgumento.validarMenorIgual;


@Getter
public class Inventario {

    private static final String SE_DEBE_INGRESAR_CODIGO="Se debe ingresar el codigo del producto";
    private static final String SE_DEBE_INGRESAR_FECHA="Se debe ingresar la fecha de ingreso";
    private static final String SE_DEBE_INGRESAR_IDPRODUCTO= "Se debe ingresar el idProducto";
    private static final String SE_DEBE_INGRESAR_CANTIDAD_POSITIVA="La cantidad debe ser un valor positivo";
    private static final String SE_DEBE_INGRESAR_DISPONIBILIDAD_POSITIVA="La disponibilidad debe ser un valor positivo";
    private static final String CANTIDAD_MAYOR_IGUAL="La cantidad debe ser mayor o igual a disponibilidad";

    private Integer codigo;
    private LocalDate fechaIngreso;
    private int cantidad;
    private int disponible;
    private Integer idProducto;

    public Inventario(Integer codigo, LocalDate fechaIngreso, int cantidad, int disponible, Integer idProducto) {
        validarObligatorio(fechaIngreso,SE_DEBE_INGRESAR_FECHA);
        validarObligatorio(idProducto,SE_DEBE_INGRESAR_IDPRODUCTO);
        validarPositivo(cantidad,SE_DEBE_INGRESAR_CANTIDAD_POSITIVA);
        validarPositivo(disponible,SE_DEBE_INGRESAR_DISPONIBILIDAD_POSITIVA);
        validarMenorIgual(disponible,cantidad,CANTIDAD_MAYOR_IGUAL);
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
        this.disponible = disponible;
        this.idProducto = idProducto;
    }
}
