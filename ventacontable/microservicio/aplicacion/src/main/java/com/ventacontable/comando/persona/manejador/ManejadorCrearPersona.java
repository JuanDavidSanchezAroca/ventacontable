package com.ventacontable.comando.persona.manejador;

import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.comando.persona.fabrica.PersonaFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.persona.modelo.entidad.Persona;
import com.ventacontable.persona.servicio.CrearPersonaServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, Integer> {

    private final CrearPersonaServicio crearPersonaServicio;
    private final PersonaFabrica personaFabrica;

    public ManejadorCrearPersona(CrearPersonaServicio crearPersonaServicio, PersonaFabrica personaFabrica) {
        this.crearPersonaServicio = crearPersonaServicio;
        this.personaFabrica = personaFabrica;
    }

    @Override
    public Integer ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.personaFabrica.ejecutar(comandoPersona);
        return this.crearPersonaServicio.ejecutar(persona);
    }

}


