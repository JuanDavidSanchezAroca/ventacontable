package com.ventacontable.producto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precioMinimo;
    private double precioMaximo;
    private double precioBase;
}
