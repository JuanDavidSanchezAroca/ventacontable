package com.ventacontable.usuario.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Usuario {
    private String correo;
    private String password;
}
