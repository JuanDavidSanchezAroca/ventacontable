package com.ventacontable.adaptador.repositorio.producto;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.producto.modelo.entidad.Categoria;
import com.ventacontable.producto.puerto.repositorio.RepositorioCategoria;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
