package com.ventacontable.adaptador.dao.producto;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.producto.modelo.dto.DtoProducto;
import com.ventacontable.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProductoAdaptador implements DaoProducto {

    private static final String ID = "id";

    @SqlStatement(namespace = "producto", value = "buscar_por_id")
    private static String sqlBuscarPorId;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoProductoAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean existeIdProducto(int idProducto) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(ID,idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlBuscarPorId,parameterSource,Boolean.class);
    }

    @Override
    public List<DtoProducto> listar() {
        return null;
    }

    @Override
    public DtoProducto obtener(Integer idProducto) {
        return null;
    }
}
