package com.ventacontable.adaptador.dao.categoria;

import com.ventacontable.adaptador.dao.categoria.mapeo.MapeoCategoria;
import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.categoria.puerto.dao.DaoCategoria;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCategoriaAdaptador implements DaoCategoria {

    private static final String NOMBRE = "nombre";
    private static final String ID = "id";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "categoria", value = "buscar_nombre")
    private static String sqlBuscarNombre;

    @SqlStatement(namespace = "categoria", value = "buscar_id_nombre")
    private static String sqlBuscarIdNombre;

    @SqlStatement(namespace = "categoria", value = "buscar_por_id")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace = "categoria", value = "obtener_por_id")
    private static String sqlObtenerPorId;

    public DaoCategoriaAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate=customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean existeNombreCategoria(String nombreCategoria) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(NOMBRE, nombreCategoria);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarNombre, paramSource, Boolean.class);
    }

    @Override
    public boolean existeNombreCategoria(Integer idCategoria, String nombreCategoria) {
        MapSqlParameterSource parameterSource= new MapSqlParameterSource();
        parameterSource.addValue(NOMBRE, nombreCategoria);
        parameterSource.addValue(ID, idCategoria);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarIdNombre, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeIdCategoria(Integer idCategoria) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(ID, idCategoria);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarPorId, parameterSource, Boolean.class);

    }

    @Override
    public List<Integer> existeIdCategoriaBatch(List<Integer> categorias) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(ID,categorias);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerPorId,parameterSource, new MapeoCategoria());
    }
}
