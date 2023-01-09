package com.ventacontable.producto.puerto.dao;

public interface DaoCategoria {
    /**
     * Permite validar si el nombre de categoria ya existe
     *
     * @param nombreCategoria
     * @return true si existe, false en caso contrario
     */
    boolean existeNombreCategoria(String nombreCategoria);

    /**
     * Permite validar si una categoria diferente a la que voy a actualizar ya usa este nombre
     *
     * @param idCategoria
     * @return true si existe, false en caso contrario
     */
    boolean existeNombreCategoria(Integer idCategoria, String nombreCategoria);

    /**
     * Permite validar si existe categoria con id
     *
     * @param idCategoria
     * @return true si existe, false en caso contrario
     */
    boolean existeIdCategoria(Integer idCategoria);

}
