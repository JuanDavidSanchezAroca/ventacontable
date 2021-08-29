package com.ventacontable.inventario.puerto.dao;

import com.ventacontable.inventario.modelo.dto.DtoInventario;

import java.util.List;

public interface DaoInventario {

    /**
     * Metodo que verifica la existencia de un registro e
     * @param idInventario identificador del inventario
     * @return tru, si existe, false caso contrario
     */
    boolean existe(int idInventario);

    /**
     * Metodo que recupera el registro de un inventario
     * @param idInventario identificador del inventario
     * @return Inventario
     */
    DtoInventario obtener(int idInventario);

    /**
     * Metodo que recupera el listado de registro de inventarios
     * @return lista inventarios
     */
    List<DtoInventario> listar();

    /**
     * Metodo que recupera el listado de registro de inventarios dado un producto
     * @param idProducto identificadorProducto
     * @return listado inventarios
     */
    List<DtoInventario> listarPorIdProducto(int idProducto);
}
