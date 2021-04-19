package com.ventacontable.usuario.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{
    private int idUsuario;
    private String nombreCompleto;
    private String password;
    private String correo;
    private String imagen;
}
