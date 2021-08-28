package com.ventacontable.producto.consulta;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.producto.modelo.dto.DtoProducto;
import com.ventacontable.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerProducto {

    private final DaoProducto daoProducto;

    public ManejadorObtenerProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public ComandoRespuesta<DtoProducto> ejecutar(Integer idProducto){
        return new ComandoRespuesta(this.daoProducto.obtener(idProducto));
    }
}
