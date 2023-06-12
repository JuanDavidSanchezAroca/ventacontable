package com.ventacontable.usuario.puerto.repositorio;

import com.ventacontable.usuario.modelo.Rol;

public interface RepositorioRol {

    /**
     * Metodo que sirve para registrar un rol
     * @param rol
     * @return identificador del rol
     */
    Long registrar(Rol rol);
}
