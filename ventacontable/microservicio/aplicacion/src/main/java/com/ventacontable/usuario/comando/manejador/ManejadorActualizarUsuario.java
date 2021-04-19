package com.ventacontable.usuario.comando.manejador;

import com.ventacontable.manejador.ManejadorComando;
import com.ventacontable.usuario.comando.ComandoUsuario;
import com.ventacontable.usuario.comando.fabrica.FabricaUsuario;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.servicio.ServicioActualizarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorActualizarUsuario implements ManejadorComando<ComandoUsuario> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioActualizarUsuario servicioActualizarUsuario;

    public ManejadorActualizarUsuario(FabricaUsuario fabricaUsuario,ServicioActualizarUsuario servicioActualizarUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioActualizarUsuario = servicioActualizarUsuario;
    }

    @Override
    public void ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        this.servicioActualizarUsuario.ejecutar(usuario);
    }
}
