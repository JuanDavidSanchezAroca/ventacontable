package com.ventacontable.adaptador.dao.persona;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.persona.puerto.dao.DaoPersona;
import com.ventacontable.producto.puerto.dao.DaoCategoria;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoPersonaAdaptador implements DaoPersona {

    private static final String IDENTIFICACION = "identificacion";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "persona", value = "buscar_por_identificacion.sql")
    private static String sqlBuscarPorIdentificacion;

    public DaoPersonaAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean existeIdentificacionPersona(String identificacion) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(IDENTIFICACION, identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarPorIdentificacion, parameterSource, Boolean.class);
    }
}


