package com.ventacontable.producto.adaptador.dao;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.producto.modelo.dto.DtoProducto;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DaoProductoPostgres implements DaoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="buscarPorId")
    private static String sqlBuscarPorId;

    public DaoProductoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean existeIdProducto(int idProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProducto", idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId,paramSource, Boolean.class);
    }
}
