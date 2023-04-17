package com.ventacontable.categoria.puerto.repositorio;

import com.ventacontable.categoria.modelo.Categoria;

import java.util.List;

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

    /**
     * Metodo que permite asociar un producto a varias categorias
     * @param idProducto identificador del producto
     * @param categorias lista de identificadores de las categorias
     * @return
     */
    int asociarCategoriaProducto(Integer idProducto, List<Integer> categorias);
}
