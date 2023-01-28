package com.ventacontable.categoria.puerto.repositorio;

import com.ventacontable.categoria.modelo.Categoria;

public interface RepositorioCategoria {
    /**
     * Permite crear una categoria
     *
     * @param categoria
     * @return el id generado
     */
    int crear(Categoria categoria);

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
    int actualizar(Categoria categoria, Integer idCategoria);


}
