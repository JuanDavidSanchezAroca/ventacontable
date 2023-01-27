package com.ventacontable.persona.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.html.Option;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
    CC,
    TI,
    PASS,
    CE,
    NIP,
    NIT
}
