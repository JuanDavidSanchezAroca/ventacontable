package com.ventacontable.persona.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.persona.modelo.entidad.Persona;
import com.ventacontable.persona.puerto.dao.DaoPersona;
import com.ventacontable.persona.puerto.repositorio.RepositorioPersona;

public class ActualizarPersonaServicio {
    private static final String NO_EXISTE_PERSONA = "identificacion no encontrada";
    private final RepositorioPersona repositorioPersona;

    private final DaoPersona daoPersona;


    public ActualizarPersonaServicio(RepositorioPersona repositorioPersona, DaoPersona daoPersona) {
        this.repositorioPersona = repositorioPersona;
        this.daoPersona = daoPersona;
    }

    public String ejecutar(Persona persona) {
        validarExistencia(persona.getIdentificacion());
        return repositorioPersona.actualizar(persona);
    }

    public void validarExistencia(String identificacion) {
        if (!daoPersona.existeIdentificacionPersona(identificacion)) {
            throw new ExcepcionSinDatos(NO_EXISTE_PERSONA);
        }
    }
}
