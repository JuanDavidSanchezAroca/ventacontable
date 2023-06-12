package com.ventacontable.adaptador.repositorio.usuario;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.usuario.modelo.Rol;
import com.ventacontable.usuario.puerto.repositorio.RepositorioRol;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRolAdaptador implements RepositorioRol {

    @SqlStatement(namespace = "rol", value = "registrar")
    private static String sqlRegistrar;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioRolAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long registrar(Rol rol) {
        return this.customNamedParameterJdbcTemplate.crear(rol, sqlRegistrar, "id");
    }
}
