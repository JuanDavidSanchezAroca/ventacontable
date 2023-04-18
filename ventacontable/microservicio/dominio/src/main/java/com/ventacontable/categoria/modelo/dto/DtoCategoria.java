package com.ventacontable.categoria.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoCategoria {
    Integer id;
    private String nombre;
    private String descripcion;
}
