package com.ventacontable.inventario.consulta;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.inventario.modelo.dto.DtoInventario;
import com.ventacontable.inventario.puerto.dao.DaoInventario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerInventarioPorProducto {

    private final DaoInventario daoInventario;

    public ManejadorObtenerInventarioPorProducto(DaoInventario daoInventario) {
        this.daoInventario = daoInventario;
    }

    public ComandoRespuesta<DtoInventario> ejecutar(int idProducto){
        return new ComandoRespuesta(this.daoInventario.listarPorIdProducto(idProducto));
    }
}
