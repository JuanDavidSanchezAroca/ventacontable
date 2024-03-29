package com.ventacontable.adaptador.repositorio.producto;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoPostgres implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "producto", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="producto", value="existeNombre")
    private static String sqlExisteNombre;

    public RepositorioProductoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Producto producto) {
        return this.customNamedParameterJdbcTemplate.crear(producto,sqlCrear,"id");
    }

    @Override
    public void actualizar(Producto producto) {
        this.customNamedParameterJdbcTemplate.actualizar(producto,sqlActualizar);
    }

    @Override
    public boolean existeNombre(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteNombre,paramSource, Boolean.class);
    }
}
