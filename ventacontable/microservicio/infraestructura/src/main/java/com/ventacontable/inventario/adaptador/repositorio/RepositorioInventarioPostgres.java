package com.ventacontable.inventario.adaptador.repositorio;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import com.ventacontable.inventario.puerto.repositorio.RepositorioInventario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInventarioPostgres implements RepositorioInventario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="inventario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "inventario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "inventario", value = "eliminar")
    private static String sqlEliminar;

    public RepositorioInventarioPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public long crear(Inventario inventario) {
        return this.customNamedParameterJdbcTemplate.crear(inventario,sqlCrear,"id_inventario");
    }

    @Override
    public void actualizar(Inventario inventario) {
        this.customNamedParameterJdbcTemplate.actualizar(inventario,sqlActualizar);
    }

    @Override
    public void eliminar(int idInventario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idInventario", idInventario);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,paramSource);
    }
}
