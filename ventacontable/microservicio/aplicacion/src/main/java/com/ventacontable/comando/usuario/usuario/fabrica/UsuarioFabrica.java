package com.ventacontable.comando.usuario.usuario.fabrica;

import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.usuario.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFabrica {
    public Usuario ejecutar(ComandoUsuario comandoUsuario){
        return new Usuario(comandoUsuario.getUsuario(), comandoUsuario.getPassword());
    }
}
