package com.ventacontable.producto.consulta;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.producto.modelo.dto.DtoProducto;
import com.ventacontable.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarProducto  {

    private final DaoProducto daoProducto;

    public ManejadorListarProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public ComandoRespuesta<DtoProducto> ejecutar(){
        return new ComandoRespuesta(this.daoProducto.listar());
    }
}
