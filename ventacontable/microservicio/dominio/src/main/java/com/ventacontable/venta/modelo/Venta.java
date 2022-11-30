package com.ventacontable.venta.modelo;

import com.ventacontable.comun.modelo.Item;
import com.ventacontable.usuario.modelo.Persona;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

import static com.ventacontable.dominio.ValidadorArgumento.*;

@Getter
public class Venta {
    private static final String CODIGO_NO_VACIO = "El còdigo no puede ser vacìo";
    private static final String FECHA_NO_VALIDA = "la fecha no es vàlida";
    private static final String VALOR_TOTAL_NO_PERMITIDO = "El valor total no es permitido";
    private static final String CANTIDAD_ITEMS_NO_PERMITIDO = "El nùmero de items no es permitido";
    private static final String DEBE_EXISTIR_VENDEDOR = "Debe de existir un  vendedor";
    private static final String DEBE_EXISTIR_COMPRADOR = "Debe de existir un  vendedor";
    private int idVenta;
    private String codigo;
    private LocalDate fecha;
    private double valorTotal;
    private List<Item> items;
    private Persona vendedor;
    private Persona comprador;

    public Venta(int idVenta, String codigo, LocalDate fecha, double valorTotal, List<Item> items, Persona vendedor,
                 Persona comprador) {
        validarObligatorio(codigo,CODIGO_NO_VACIO);
        validarMenor(fecha, LocalDate.now(),FECHA_NO_VALIDA);
        validarPositivo(valorTotal, VALOR_TOTAL_NO_PERMITIDO);
        validarNoVacio(items,CANTIDAD_ITEMS_NO_PERMITIDO);
        validarObligatorio(vendedor,DEBE_EXISTIR_VENDEDOR);
        validarObligatorio(comprador,DEBE_EXISTIR_COMPRADOR);
        this.idVenta = idVenta;
        this.codigo = codigo;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.items = items;
        this.vendedor = vendedor;
        this.comprador = comprador;
    }
}
