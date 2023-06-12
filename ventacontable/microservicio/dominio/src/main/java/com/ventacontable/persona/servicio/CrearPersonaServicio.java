package com.ventacontable.persona.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.persona.modelo.entidad.Persona;
import com.ventacontable.persona.puerto.dao.DaoPersona;
import com.ventacontable.persona.puerto.repositorio.RepositorioPersona;
import com.ventacontable.usuario.servicio.usuario.CrearUsuarioServicio;

public class CrearPersonaServicio {

        private static final String YA_EXISTE_PERSONA = "La identificacion ingresada ya existe";
        private final RepositorioPersona repositorioPersona;
        private final DaoPersona daoPersona;
        private final CrearUsuarioServicio crearUsuarioServicio;

        public CrearPersonaServicio(RepositorioPersona repositorioPersona,
                                    DaoPersona daoPersona,
                                    CrearUsuarioServicio crearUsuarioServicio) {
            this.repositorioPersona = repositorioPersona;
            this.daoPersona = daoPersona;
            this.crearUsuarioServicio = crearUsuarioServicio;
        }

        public Integer ejecutar(Persona persona) {
            validarPreviaExistencia(persona.getIdentificacion());
            return repositorioPersona.crear(persona);
        }

        private void validarPreviaExistencia(String identificacion) {
            if (daoPersona.existeIdentificacionPersona(identificacion)) {
                throw new ExcepcionDuplicidad(YA_EXISTE_PERSONA);
            }
        }
    }


