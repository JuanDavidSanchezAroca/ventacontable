package com.ventacontable.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProducto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precioMinimo;
    private double precioMaximo;
    private double precioBase;
}
