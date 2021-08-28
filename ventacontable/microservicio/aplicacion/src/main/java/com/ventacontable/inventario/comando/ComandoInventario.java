package com.ventacontable.inventario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoInventario {

    private Integer codigo;
    private LocalDate fechaIngreso;
    private int cantidad;
    private int disponible;
    private Integer idProducto;
}
