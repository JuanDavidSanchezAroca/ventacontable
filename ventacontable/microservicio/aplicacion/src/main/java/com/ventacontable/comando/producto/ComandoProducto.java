package com.ventacontable.comando.producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {
    private int idProducto;
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioMinimo;
    private double precioMaximo;
    private double precioBase;
    private String talla;
    private String color;
    private int cantidadDisponible;
    private List<Integer> categorias;
}
