package com.ventacontable.separado.puerto.dao;

public interface DaoSeparado {

    /**
     * Permite validar si el separado existe
     *
     * @param idSeparado
     * @return true si existe, false en caso contrario
     */
    boolean existeSeparado(Integer idSeparado);
}
