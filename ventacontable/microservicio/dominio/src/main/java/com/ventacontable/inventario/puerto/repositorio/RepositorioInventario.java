package com.ventacontable.inventario.puerto.repositorio;

import com.ventacontable.inventario.modelo.entidad.Inventario;

public interface RepositorioInventario {

    /**
     * Metodo que permite la creacion de inventario de un producto
     * @param inventario inventario
     * @return identificador del inventario
     */
    long crear(Inventario inventario);

    /**
     * Metodo que permite actualizar un registro de un inventario
     * @param inventario inventario
     * @return identificador del inventario
     */
    void actualizar(Inventario inventario);

    /**
     * Metodo que elimina el registro de un inventario
     * @param idInventario identificador de un inventario
     */
    void eliminar(int idInventario);
}
