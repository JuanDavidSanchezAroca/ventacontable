package com.ventacontable.usuario.puerto.repositorio;

import com.ventacontable.usuario.modelo.Usuario;

public interface RepositorioUsuario {

        /**
         * Metodo que permite registrar un nuevo usuario
         * @param usuario usuario
         * @return identificador del permiso creado
         */
        Integer registrar(Usuario usuario);

        /**
         * Metodo que permite actualizar un usuario
         * @param usuario usuario
         * @return identificador del permiso
         */
        Integer actualizar(Usuario usuario);

        /**
         * Metodo que permite actualizar un usuario
         * @param usuario usuario
         * @return identificador del permiso
         */
        Integer actualizar(Usuario usuario, Integer id);
}
