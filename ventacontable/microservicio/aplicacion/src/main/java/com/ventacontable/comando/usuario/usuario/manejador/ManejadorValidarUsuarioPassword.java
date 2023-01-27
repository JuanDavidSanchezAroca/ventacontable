package com.ventacontable.comando.usuario.usuario.manejador;

import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.comando.usuario.usuario.fabrica.UsuarioFabrica;
import com.ventacontable.usuario.modelo.Usuario;
import com.ventacontable.usuario.servicio.usuario.LoginUsuarioServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorValidarUsuarioPassword {
    private final UsuarioFabrica usuarioFabrica;

    private final LoginUsuarioServicio loginUsuarioServicio;

    public ManejadorValidarUsuarioPassword(LoginUsuarioServicio loginUsuarioServicio, UsuarioFabrica usuarioFabrica) {
        this.loginUsuarioServicio = loginUsuarioServicio;
        this.usuarioFabrica = usuarioFabrica;
    }

    public boolean ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.usuarioFabrica.ejecutar(comandoUsuario);
        return this.loginUsuarioServicio.ejecutar(usuario);
    }

}



