package com.ventacontable.adaptador.dao.categoria.mapeo;

import com.ventacontable.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCategoria implements RowMapper<Integer>, MapperResult {
    @Override
    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
        int numero = rs.getInt("id");
        return numero;
    }
}
