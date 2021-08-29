package com.ventacontable.inventario.adaptador.dao;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.inventario.modelo.dto.DtoInventario;
import com.ventacontable.inventario.puerto.dao.DaoInventario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoInventarioPostgres implements DaoInventario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="inventario", value="buscarPorId")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace = "inventario", value = "obtener")
    private static String sqlObtener;

    @SqlStatement(namespace = "inventario", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "inventario", value = "listarProducto")
    private static String sqlListarProducto;

    public DaoInventarioPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean existe(int idInventario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idInventario", idInventario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId,paramSource,Boolean.class);
    }

    @Override
    public DtoInventario obtener(int idInventario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idInventario", idInventario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener,paramSource, new MapeoInventario());
    }

    @Override
    public List<DtoInventario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoInventario());
    }

    @Override
    public List<DtoInventario> listarPorIdProducto(int idProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProducto", idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarProducto,paramSource,new MapeoInventario());
    }
}
