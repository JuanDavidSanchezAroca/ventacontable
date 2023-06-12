package com.ventacontable.usuario.puerto.dao;

public interface DaoRol {

    /**
     * Metodo para buscar validar si un rol existe por nombre
     * @param nombre
     * @return true si existe, false caso contrario
     */
    boolean buscarNombre(String nombre);
}
