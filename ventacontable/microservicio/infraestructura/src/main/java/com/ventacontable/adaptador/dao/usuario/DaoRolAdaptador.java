package com.ventacontable.adaptador.dao.usuario;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.usuario.modelo.dto.DtoRol;
import com.ventacontable.usuario.puerto.dao.DaoRol;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoRolAdaptador implements DaoRol {
    private static final String NOMBRE = "nombre";
    @SqlStatement(namespace = "rol", value = "buscar_nombre")
    private static String sqlBuscarNombre;
    @SqlStatement(namespace = "rol", value = "listar")
    private static String sqlListar;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoRolAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
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
    public List<DtoRol> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar,new BeanPropertyRowMapper<>(DtoRol.class));
    }
}
