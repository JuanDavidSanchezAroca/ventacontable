package com.ventacontable.adaptador.repositorio.inventario;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import com.ventacontable.inventario.puerto.repositorio.RepositorioInventario;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInventarioAdaptador implements RepositorioInventario {


    @SqlStatement(namespace = "inventario", value = "crear")
    private static String sqlRegistrar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioInventarioAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public long crear(Inventario inventario) {
        return this.customNamedParameterJdbcTemplate.crear(inventario, sqlRegistrar, "id").intValue();
    }

    @Override
    public void actualizar(Inventario inventario) {

    }

    @Override
    public void eliminar(int idInventario) {

    }
}
