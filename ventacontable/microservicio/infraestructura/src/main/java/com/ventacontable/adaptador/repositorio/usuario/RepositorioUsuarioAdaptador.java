package com.ventacontable.adaptador.repositorio.usuario;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.usuario.modelo.Usuario;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioAdaptador implements RepositorioUsuario {
    @SqlStatement(namespace = "usuario", value = "crear")
    private static String sqlRegistrar;
    @SqlStatement(namespace = "usuario", value = "actualizar")
    private static String sqlActualizar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioUsuarioAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer registrar(Usuario usuario) {
        return this.customNamedParameterJdbcTemplate.crear(usuario, sqlRegistrar, "id").intValue();
    }

    @Override
    public Integer actualizar(Usuario usuario) {
        return null;
    }

    @Override
    public Integer actualizar(Usuario usuario, Integer id) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizar, id);
        return id;
    }
}
