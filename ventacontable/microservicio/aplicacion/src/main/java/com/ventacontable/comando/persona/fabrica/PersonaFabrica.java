package com.ventacontable.comando.persona.fabrica;

import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.persona.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaFabrica {
    public Persona ejecutar(ComandoPersona comandoPersona) {
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
                comandoPersona.getUsuario());
    }
}
