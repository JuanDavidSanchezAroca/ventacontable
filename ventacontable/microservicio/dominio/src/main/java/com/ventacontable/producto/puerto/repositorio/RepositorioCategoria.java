package com.ventacontable.producto.puerto.repositorio;

import com.ventacontable.producto.modelo.entidad.Categoria;

public interface RepositorioCategoria {
    /**
     * Permite crear una categoria
     *
     * @param categoria
     * @return el id generado
     */
    Long crear(Categoria categoria);

    /**
     * Permite eliminar una categoria
     *
     * @param idCategoria
     */
    void eliminar(int idCategoria);

    /**
     * Permite actualizar una categoria
     *
     * @param categoria
     */
    void actualizar(Categoria categoria);

    /**
     * Permite validar si el nombre de categoria ya existe
     *
     * @param nombreCategoria
     * @return true si existe, false en caso contrario
     */
    boolean existeNombreCategoria(String nombreCategoria);
}
