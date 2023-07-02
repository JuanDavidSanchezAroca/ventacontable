package com.ventacontable.comando.persona.manejador;

import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.comando.persona.fabrica.PersonaFabrica;
import com.ventacontable.comando.usuario.usuario.fabrica.UsuarioFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.notificacion.servicio.NotificarCrearUsuarioServicio;
import com.ventacontable.persona.modelo.entidad.Persona;
import com.ventacontable.persona.servicio.CrearPersonaServicio;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.servicio.usuario.CrearUsuarioServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, Integer> {

    private final CrearPersonaServicio crearPersonaServicio;
    private final CrearUsuarioServicio crearUsuarioServicio;
    private final NotificarCrearUsuarioServicio notificarCrearUsuarioServicio;
    private final PersonaFabrica personaFabrica;
    private final UsuarioFabrica usuarioFabrica;

    public ManejadorCrearPersona(CrearPersonaServicio crearPersonaServicio,
                                 CrearUsuarioServicio crearUsuarioServicio,
                                 PersonaFabrica personaFabrica,
                                 UsuarioFabrica usuarioFabrica,
                                 NotificarCrearUsuarioServicio notificarCrearUsuarioServicio) {
        this.crearPersonaServicio = crearPersonaServicio;
        this.crearUsuarioServicio = crearUsuarioServicio;
        this.personaFabrica = personaFabrica;
        this.usuarioFabrica = usuarioFabrica;
        this.notificarCrearUsuarioServicio = notificarCrearUsuarioServicio;
    }

    @Override
    public Integer ejecutar(ComandoPersona comandoPersona) {
        Usuario usuario = this.usuarioFabrica.ejecutar(comandoPersona.getUsuario());
        int idUsuario = this.crearUsuarioServicio.ejecutar(usuario);
        Persona persona = this.personaFabrica.ejecutar(comandoPersona,idUsuario);
        int idPersona = this.crearPersonaServicio.ejecutar(persona);
        this.notificarCrearUsuarioServicio.ejecutar(usuario);
        return idPersona;
    }

}


