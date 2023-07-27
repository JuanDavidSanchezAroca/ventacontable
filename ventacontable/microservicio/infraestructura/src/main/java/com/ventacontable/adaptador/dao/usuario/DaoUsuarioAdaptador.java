package com.ventacontable.adaptador.dao.usuario;

import com.ventacontable.adaptador.dao.usuario.mapeo.MapeoUsuario;
import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.dao.DaoUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoUsuarioAdaptador implements DaoUsuario {
    private static final String NOMBRE = "usuario";
    private static final String PASSWORD = "password";

    private static final String ID = "id";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "usuario", value = "existe")
    private static String sqlBuscarNombre;

    @SqlStatement(namespace = "usuario", value = "obtener_usuario")
    private static  String sqlObtenerUsuario;

    @SqlStatement(namespace = "usuario", value = "existeId")
    private static String sqlBuscarId;

    @SqlStatement(namespace = "usuario", value = "validar_usuario_y_password")
    private static String sqlValidarUsuarioPassword;

    public DaoUsuarioAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean buscarUsuario(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(NOMBRE, nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarNombre, paramSource, Boolean.class);
    }

    @Override
    public boolean buscarId(Integer id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(ID, id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarId, parameterSource, Boolean.class);
    }

    @Override
    public boolean validarUsuarioPassword(Usuario usuario) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(PASSWORD, usuario.getPassword());
        parameterSource.addValue(NOMBRE, usuario.getUsuario());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlValidarUsuarioPassword, parameterSource, Boolean.class);
    }

    @Override
    public Usuario buscarUsuarioByEmail(String email) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(NOMBRE, email);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerUsuario, parameterSource, new MapeoUsuario());
    }

}


