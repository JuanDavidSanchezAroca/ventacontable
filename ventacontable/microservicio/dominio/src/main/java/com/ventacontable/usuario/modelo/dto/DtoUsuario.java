package com.ventacontable.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private int idUsuario;
    private String nombreCompleto;
    private String password;
    private String correo;
    private String imagen;
}
