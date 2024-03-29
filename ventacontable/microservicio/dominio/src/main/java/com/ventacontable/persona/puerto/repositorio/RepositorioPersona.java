package com.ventacontable.persona.puerto.repositorio;

import com.ventacontable.persona.modelo.entidad.Persona;

public interface RepositorioPersona {

        /**
         * Permite crear una persona
         *
         * @param persona
         * @return el id generado
         */
        int crear(Persona persona);

        /**
         * Permite eliminar una persona
         *
         * @param idPersona
         */
        void eliminar(int idPersona);

        /**
         * Permite actualizar una persona
         *
         * @param persona
         */
        String actualizar(Persona persona);

}
