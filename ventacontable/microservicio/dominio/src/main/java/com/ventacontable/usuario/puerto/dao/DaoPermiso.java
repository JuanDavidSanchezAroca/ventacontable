package com.ventacontable.usuario.puerto.dao;

public interface DaoPermiso {

    /**
     * Metodo que nos retorna si el nombre del permiso existe
     * @param nombre nombre del permiso
     * @return true si existe, false, caso contrario
     */
    boolean buscarNombre(String nombre);

    /**
     * Metodo que nos retorna si el nombre del permiso existe
     * @param id identificador del permiso
     * @return true si existe, false, caso contrario
     */
    boolean buscarId(Integer id);
}
