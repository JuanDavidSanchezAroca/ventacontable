package com.ventacontable.adaptador.repositorio.separado;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.separado.modelo.Separado;
import com.ventacontable.separado.puerto.repositorio.RepositorioSeparado;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSeparadoAdaptador implements RepositorioSeparado {

    @SqlStatement(namespace = "separado", value = "registrar")
    private static String sqlRegistrar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioSeparadoAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer crear(Separado separado) {
        return this.customNamedParameterJdbcTemplate.crear(separado,sqlRegistrar,"id").intValue();
    }
}
