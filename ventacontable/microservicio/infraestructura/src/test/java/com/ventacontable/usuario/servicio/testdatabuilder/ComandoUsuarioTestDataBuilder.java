package com.ventacontable.usuario.servicio.testdatabuilder;

import com.ventacontable.usuario.comando.ComandoUsuario;

import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private String idUsuario;
    private String nombreCompleto;
    private String password;
    private String correo;
    private String imagen;

    public ComandoUsuarioTestDataBuilder() {
        idUsuario = UUID.randomUUID().toString();
        nombreCompleto = UUID.randomUUID().toString();
        password = "1234";
        correo = UUID.randomUUID().toString();
        imagen = "imagen";
    }

    public ComandoUsuarioTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(idUsuario,nombreCompleto, password,correo,imagen);
    }
}
