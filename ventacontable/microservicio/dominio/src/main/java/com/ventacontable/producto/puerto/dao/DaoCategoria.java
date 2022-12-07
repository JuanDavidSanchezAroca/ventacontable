package com.ventacontable.producto.puerto.dao;

public interface DaoCategoria {
    /**
     * Permite validar si el nombre de categoria ya existe
     *
     * @param nombreCategoria
     * @return true si existe, false en caso contrario
     */
    boolean existeNombreCategoria(String nombreCategoria);
}
