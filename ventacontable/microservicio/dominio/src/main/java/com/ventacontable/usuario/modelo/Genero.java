package com.ventacontable.usuario.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {
    MASCULINO("MASCULINO"),
    FEMENINO("FEMENINO");
    private String value;
}
