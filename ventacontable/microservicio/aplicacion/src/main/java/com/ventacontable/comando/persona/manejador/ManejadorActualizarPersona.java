package com.ventacontable.comando.persona.manejador;

import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.comando.persona.fabrica.PersonaFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.persona.modelo.entidad.Persona;
import com.ventacontable.persona.servicio.ActualizarPersonaServicio;
import org.springframework.stereotype.Component;

@Component
 public class ManejadorActualizarPersona implements ManejadorComandoRespuesta<ComandoPersona, String> {
    private final ActualizarPersonaServicio actualizarPersonaServicio;
    private final PersonaFabrica personaFabrica;

    public ManejadorActualizarPersona(ActualizarPersonaServicio actualizarPersonaServicio, PersonaFabrica personaFabrica){
        this.actualizarPersonaServicio = actualizarPersonaServicio;
        this.personaFabrica = personaFabrica;
    }
    @Override
    public String ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.personaFabrica.ejecutar(comandoPersona);
        return this.actualizarPersonaServicio.ejecutar(persona);
    }
}
