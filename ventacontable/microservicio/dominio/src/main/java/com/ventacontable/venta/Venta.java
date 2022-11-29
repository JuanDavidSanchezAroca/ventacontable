package com.ventacontable.venta;

import com.ventacontable.comun.modelo.Item;
import com.ventacontable.usuario.modelo.Persona;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Venta {
    private int idVenta;
    private String codigo;
    private LocalDate fecha;
    private double valorTotal;
    private List<Item> items;
    private Persona vendedor;
    private Persona comprador;
}
