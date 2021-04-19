package com.ventacontable.usuario.comando.manejador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.servicio.ServicioCrearUsuario;
import com.ventacontable.usuario.comando.fabrica.FabricaUsuario;
import org.springframework.stereotype.Component;

import com.ventacontable.usuario.comando.ComandoUsuario;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<Long>> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCrearUsuario servicioCrearUsuario;

    public ManejadorCrearUsuario(FabricaUsuario fabricaUsuario, ServicioCrearUsuario servicioCrearUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
    }
}
