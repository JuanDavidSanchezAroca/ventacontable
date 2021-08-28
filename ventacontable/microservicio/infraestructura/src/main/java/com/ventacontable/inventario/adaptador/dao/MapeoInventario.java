package com.ventacontable.inventario.adaptador.dao;

import com.ventacontable.infraestructura.jdbc.MapperResult;
import com.ventacontable.inventario.modelo.dto.DtoInventario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoInventario implements  RowMapper<DtoInventario>, MapperResult {

    @Override
    public DtoInventario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer codigo = rs.getInt("id_inventario");
        LocalDate fecha= rs.getDate("fecha_ingreso").toLocalDate();
        int cantidad= rs.getInt("cantidad");
        int disponible = rs.getInt("disponible");
        int idProducto = rs.getInt("id_producto");
        return new DtoInventario(codigo,fecha,cantidad,disponible,idProducto);
    }
}
