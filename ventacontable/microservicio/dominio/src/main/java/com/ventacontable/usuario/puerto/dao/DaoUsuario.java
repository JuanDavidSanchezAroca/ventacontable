package com.ventacontable.usuario.puerto.dao;

import com.ventacontable.usuario.modelo.Usuario;

public interface DaoUsuario {

    /**
     * Busca usuario por el nombre de usuario
     *
     * @param usuario
     * @return
     */
    boolean buscarUsuario(String usuario);

    /**
     * Metodo que nos retorna si el id del usuario existe
     *
     * @param id identificador del usuario
     * @return true si existe, false, caso contrario
     */
    boolean buscarId(Integer id);

    boolean validarUsuarioPassword(Usuario usuario);
}


