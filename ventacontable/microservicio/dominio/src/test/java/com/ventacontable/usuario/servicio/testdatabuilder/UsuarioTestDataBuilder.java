package com.ventacontable.usuario.servicio.testdatabuilder;

import com.ventacontable.usuario.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {

    private int idUsuario;
    private String nombreCompleto;
    private String password;
    private String correo;
    private String imagen;

    public UsuarioTestDataBuilder() {
       this.idUsuario = 1;
       this.nombreCompleto = "juan";
       this.password ="12345";
       this.correo = "juan.david748@gmail.com";
       this.imagen = "imagen";
    }

    public UsuarioTestDataBuilder conPassword(String password) {
        this.password = password;
        return this;
    }

    public Usuario build() {
        return new Usuario(idUsuario,nombreCompleto,password,correo,imagen);
    }
}
