package com.ventacontable.adaptador.repositorio.persona;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.persona.modelo.entidad.Persona;
import com.ventacontable.persona.puerto.repositorio.RepositorioPersona;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaAdaptador implements RepositorioPersona {


    @SqlStatement(namespace = "persona", value = "registrar")
    private static String sqlRegistrar;
    @SqlStatement(namespace = "persona", value = "actualizar")
    private static String sqlActualizar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPersonaAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public int crear(Persona persona) {
        return this.customNamedParameterJdbcTemplate.crear(persona, sqlRegistrar, "id").intValue();
    }

    @Override
    public void eliminar(int idPersona) {

    }

    @Override
    public String actualizar(Persona persona) {
        this.customNamedParameterJdbcTemplate.actualizar(persona, sqlActualizar);
        return persona.getIdentificacion();
    }
}


