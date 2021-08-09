package com.ventacontable.producto.puerto.repositorio;

import com.ventacontable.producto.modelo.entidad.Producto;

public interface RepositorioProducto {

    /**
     * Permite crear un producto
     * @param producto
     * @return el id generado
     */
    Long crear(Producto producto);

    /**
     * Permite actualizar un producto
     * @param producto
     * @return el id del producto
     */
    void actualizar(Producto producto);

    /**
     * Permite validar si un nombre de producto ya existe
     * @param nombre
     * @return true, si existe, false caso contrario
     */
    boolean existeNombre(String nombre);

}
