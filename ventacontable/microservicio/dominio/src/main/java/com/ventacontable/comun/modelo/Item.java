package com.ventacontable.comun.modelo;

import com.ventacontable.producto.modelo.entidad.Producto;
import lombok.Getter;

@Getter
public class Item {
    private Producto producto;
    private int cantidad;
    private double precioUnidad;
    private double total;
}
