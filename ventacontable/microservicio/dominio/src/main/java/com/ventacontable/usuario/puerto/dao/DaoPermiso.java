package com.ventacontable.usuario.puerto.dao;

public interface DaoPermiso {

    /**
     * Metodo que nos retorna si el nombre del permiso existe
     * @param nombre nombre del permiso
     * @return true si existe, false, caso contrario
     */
    boolean buscar(String nombre);
}
