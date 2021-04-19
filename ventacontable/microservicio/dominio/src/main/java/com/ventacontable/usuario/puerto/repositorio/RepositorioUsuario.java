package com.ventacontable.usuario.puerto.repositorio;

import com.ventacontable.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {
    /**
     * Permite crear un usuario
     * @param usuario
     * @return el id generado
     */
    Long crear(Usuario usuario);

    /**
     * Permite actualizar un usuario
     * @param usuario
     */
    void actualizar(Usuario usuario);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un correo
     * @param correo
     * @return si existe o no
     */
    boolean existe(String correo);

    /**
     * Permite validar si existe un usuario con un id
     * @param idUsuario
     * @return si existe o no
     */
    boolean existeId(int idUsuario);


}
