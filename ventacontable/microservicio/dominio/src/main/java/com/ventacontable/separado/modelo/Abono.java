package com.ventacontable.separado.modelo;

import com.ventacontable.usuario.modelo.Persona;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Abono {
    private LocalDateTime fecha;
    private double valor;
    private Persona receptor;
    private Persona pagador;
}
