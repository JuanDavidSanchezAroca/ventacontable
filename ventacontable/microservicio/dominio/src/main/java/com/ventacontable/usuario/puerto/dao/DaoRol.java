package com.ventacontable.usuario.puerto.dao;

import com.ventacontable.usuario.modelo.dto.DtoRol;

import java.util.List;

public interface DaoRol {

    /**
     * Metodo para buscar validar si un rol existe por nombre
     * @param nombre
     * @return true si existe, false caso contrario
     */
    boolean buscarNombre(String nombre);

    /**
     * Metodo que lista todos los roles disponibles
     * @return
     */
    List<DtoRol> listar();
}
