package com.ventacontable.adaptador.dao.usuario;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.usuario.puerto.dao.DaoPermiso;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoPermisoAdaptador implements DaoPermiso {

    private static final String NOMBRE = "nombre";
    private static final String ID = "id";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "permiso", value = "buscar_nombre")
    private static String sqlBuscarNombre;

    @SqlStatement(namespace = "permiso", value = "buscar_id")
    private static  String sqlBuscarId;

    public DaoPermisoAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean buscarNombre(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(NOMBRE, nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarNombre, paramSource, Boolean.class);
    }

    @Override
    public boolean buscarId(Integer id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(ID,id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarId,parameterSource,Boolean.class);
    }

}
