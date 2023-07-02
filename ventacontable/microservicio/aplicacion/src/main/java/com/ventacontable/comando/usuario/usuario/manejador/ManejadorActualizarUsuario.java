package com.ventacontable.comando.usuario.usuario.manejador;

import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.comando.usuario.usuario.fabrica.UsuarioFabrica;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.servicio.usuario.ActualizarUsuarioServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarUsuario {

    private final UsuarioFabrica usuarioFabrica;
    private final ActualizarUsuarioServicio actualizarUsuarioServicio;

    public ManejadorActualizarUsuario(UsuarioFabrica usuarioFabrica,
                                      ActualizarUsuarioServicio actualizarUsuarioServicio) {
        this.usuarioFabrica = usuarioFabrica;
        this.actualizarUsuarioServicio = actualizarUsuarioServicio;
    }

    @Transactional
    public Integer ejecutar(ComandoUsuario comando, Integer id) {
        Usuario usuario = this.usuarioFabrica.ejecutar(comando);
        return this.actualizarUsuarioServicio.ejecutar(usuario, id);
    }


}
