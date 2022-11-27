package com.ventacontable.usuario.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
    CC("CC"),
    TI("TI"),
    PASS("PASS"),
    CE("CE"),
    NIP("NIP"),
    NIT("NIT");
    private String value;
}
