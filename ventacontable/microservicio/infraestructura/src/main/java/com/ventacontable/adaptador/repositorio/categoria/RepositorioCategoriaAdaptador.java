package com.ventacontable.adaptador.repositorio.categoria;

import com.ventacontable.categoria.puerto.repositorio.MapeoCategoriaProducto;
import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.categoria.modelo.entidad.Categoria;
import com.ventacontable.categoria.puerto.repositorio.RepositorioCategoria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioCategoriaAdaptador implements RepositorioCategoria {

    @SqlStatement(namespace = "categoria", value = "registrar")
    private static String sqlRegistrar;

    @SqlStatement(namespace = "categoria", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "categoria", value = "asociar_categoria_producto")
    private static String sqlAsociarCategoriaProducto;

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

    @Override
    public int asociarCategoriaProducto(Integer idProducto, List<Integer> categorias) {
        this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .batchUpdate(sqlAsociarCategoriaProducto, MapeoCategoriaProducto.llenarValores(idProducto, categorias));
        return 0;
    }

}
