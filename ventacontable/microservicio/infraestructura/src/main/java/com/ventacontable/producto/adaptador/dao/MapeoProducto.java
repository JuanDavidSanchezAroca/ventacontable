package com.ventacontable.producto.adaptador.dao;

import com.ventacontable.infraestructura.jdbc.MapperResult;
import com.ventacontable.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
        int idProducto= rs.getInt("id_producto");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        double precioMinimo = rs.getDouble("precio_minimo");
        double precioMaximo = rs.getDouble("precio_maximo");
        double precioBase = rs.getDouble("precio_base");
        return new DtoProducto(idProducto,nombre,descripcion,precioMinimo,precioMaximo,precioBase);
    }
}
