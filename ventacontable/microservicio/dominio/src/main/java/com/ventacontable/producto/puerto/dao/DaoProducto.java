package com.ventacontable.producto.puerto.dao;

import com.ventacontable.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    /**
     * Metodo que busca un producto
     * @param idProducto identificador del producto
     * @return producto
     */
    boolean existeIdProducto(int idProducto);

    /**
     * Metodo que permite listar los productos
     * @return lista
     */
    List<DtoProducto> listar();


    /**
     * Metodo que permite listar un producto dado el id
     * @param idProducto identificador del producto
     * @return producto
     */
    DtoProducto obtener(Integer idProducto);
}
