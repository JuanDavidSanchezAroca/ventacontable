package com.ventacontable.adaptador.repositorio.categoria;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.categoria.modelo.Categoria;
import com.ventacontable.categoria.puerto.repositorio.RepositorioCategoria;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoriaAdaptador implements RepositorioCategoria {

    @SqlStatement(namespace = "categoria", value = "registrar")
    private static String sqlRegistrar;

    @SqlStatement(namespace = "categoria", value = "actualizar")
    private static String sqlActualizar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioCategoriaAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public int crear(Categoria categoria) {
        return this.customNamedParameterJdbcTemplate.crear(categoria, sqlRegistrar, "id").intValue();

    }

    @Override
    public void eliminar(int idCategoria) {

    }

    @Override
    public int actualizar(Categoria categoria, Integer idCategoria) {
        this.customNamedParameterJdbcTemplate.actualizar(categoria,sqlActualizar,idCategoria);
             return idCategoria;
    }

}
