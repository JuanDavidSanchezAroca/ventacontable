package com.ventacontable.usuario.comando.fabrica;

import com.ventacontable.usuario.modelo.Usuario;
import org.springframework.stereotype.Component;

import com.ventacontable.usuario.comando.ComandoUsuario;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        return new Usuario(
                comandoUsuario.getIdUsuario(),
                comandoUsuario.getNombreCompleto(),
                comandoUsuario.getPassword(),
                comandoUsuario.getCorreo(),
                comandoUsuario.getImagen()
        );
    }
}
