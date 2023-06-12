package com.ventacontable.comando.persona.fabrica;

import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.comando.usuario.usuario.fabrica.UsuarioFabrica;
import com.ventacontable.persona.modelo.entidad.Persona;
import com.ventacontable.usuario.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class PersonaFabrica {
    public Persona ejecutar(ComandoPersona comandoPersona, int idUsuario) {
        int id = idUsuario;
        if( id == 0){
            id = comandoPersona.getUsuario().getId();
        }
        return new Persona(
                comandoPersona.getIdentificacion(),
                comandoPersona.getNombre(),
                comandoPersona.getApellido(),
                comandoPersona.getTipoDocumento(),
                comandoPersona.getTelefono(),
                comandoPersona.getGenero(),
                comandoPersona.getDireccion(),
                comandoPersona.getFechaNacimiento(),
                comandoPersona.getRol(),
                id);
    }
}
