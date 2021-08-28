package com.ventacontable.producto.adaptador.dao;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.producto.modelo.dto.DtoProducto;
import com.ventacontable.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProductoPostgres implements DaoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="buscarPorId")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace = "producto", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = "producto", value = "obtener")
    private static String sqlObtener;

    public DaoProductoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean existeIdProducto(int idProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProducto", idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId,paramSource, Boolean.class);
    }

    @Override
    public List<DtoProducto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,new MapeoProducto());
    }

    @Override
    public DtoProducto obtener(Integer idProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProducto", idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener,paramSource,new MapeoProducto());
    }
}
