package com.ventacontable.adaptador.repositorio.usuario;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.usuario.modelo.Permiso;
import com.ventacontable.usuario.puerto.repositorio.RepositorioPermiso;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPermisoAdaptador implements RepositorioPermiso {

    @SqlStatement(namespace = "permiso", value = "registrar")
    private static String sqlRegistrar;
    @SqlStatement(namespace = "permiso", value = "actualizar")
    private static String sqlActualizar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPermisoAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer registrar(Permiso permiso) {
        return this.customNamedParameterJdbcTemplate.crear(permiso, sqlRegistrar, "id").intValue();
    }

    @Override
    public Integer actualizar(Permiso permiso) {
        this.customNamedParameterJdbcTemplate.actualizar(permiso,sqlActualizar);
        return permiso.getId();
    }
}
