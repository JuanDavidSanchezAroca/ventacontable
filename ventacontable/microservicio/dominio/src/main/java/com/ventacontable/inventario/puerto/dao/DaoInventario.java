package com.ventacontable.inventario.puerto.dao;

import com.ventacontable.inventario.modelo.dto.DtoInventario;

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
}
