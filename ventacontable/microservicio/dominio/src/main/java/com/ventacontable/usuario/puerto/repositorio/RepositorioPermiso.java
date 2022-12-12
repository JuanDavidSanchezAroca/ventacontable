package com.ventacontable.usuario.puerto.repositorio;

import com.ventacontable.usuario.modelo.Permiso;

public interface RepositorioPermiso {
    /**
     * Metodo que permite registrar un nuevo permiso
     * @param permiso permiso
     * @return identificador del permiso creado
     */
    Integer registrar(Permiso permiso);

    /**
     * Metodo que permite actualizar un permiso
     * @param permiso permiso
     * @return identificador del permiso
     */
    Integer actualizar(Permiso permiso);
}
