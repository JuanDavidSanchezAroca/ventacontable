package com.ventacontable.comando.usuario.usuario.manejador;

import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.comando.usuario.usuario.fabrica.UsuarioFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.servicio.usuario.CrearUsuarioServicio;
import org.springframework.stereotype.Component;

@Component
public class  ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, Integer> {
    private final CrearUsuarioServicio crearUsuarioServicio;
    private final UsuarioFabrica usuarioFabrica;

    public ManejadorCrearUsuario(CrearUsuarioServicio crearUsuarioServicio, UsuarioFabrica usuarioFabrica) {
        this.crearUsuarioServicio = crearUsuarioServicio;
        this.usuarioFabrica = usuarioFabrica;
    }

    @Override
    public Integer ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.usuarioFabrica.ejecutar(comandoUsuario);
        return this.crearUsuarioServicio.ejecutar(usuario);
    }

}

