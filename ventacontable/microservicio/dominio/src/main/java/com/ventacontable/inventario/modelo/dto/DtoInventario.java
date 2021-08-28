package com.ventacontable.inventario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoInventario {

    private Integer codigo;
    private LocalDate fechaIngreso;
    private int cantidad;
    private int disponible;
    private Integer idProducto;
}
