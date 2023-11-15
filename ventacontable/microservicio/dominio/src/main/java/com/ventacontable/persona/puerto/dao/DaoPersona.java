package com.ventacontable.persona.puerto.dao;

public interface DaoPersona {
    /**
     * Permite validar si existe una persona con la identificacion suministrada
     * @param identificacion
     * @return
     */
    boolean existeIdentificacionPersona(String identificacion);
}
