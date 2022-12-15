package com.ventacontable.usuario.puerto.dao;

public interface DaoPersona {

    /**
     * Permite validar la existencia de una persona
     *
     * @param idPersona
     * @return true si existe, false en caso contrario
     */
    boolean existePersona (Integer idPersona);

}
