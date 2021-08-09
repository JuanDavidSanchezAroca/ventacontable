package com.ventacontable.producto.puerto.dao;

import com.ventacontable.producto.modelo.dto.DtoProducto;

import java.util.Optional;

public interface DaoProducto {

    /**
     * Metodo que busca un producto
     * @param idProducto identificador del producto
     * @return producto
     */
    boolean existeIdProducto(int idProducto);
}
