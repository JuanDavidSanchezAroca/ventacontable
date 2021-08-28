package com.ventacontable.inventario.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import com.ventacontable.inventario.puerto.repositorio.RepositorioInventario;
import com.ventacontable.producto.puerto.dao.DaoProducto;

public class ServicioCrearInventario {

    private static final String NO_EXISTE_PRODUCTO="El producto ingresado no se le puede asociar inventario no existe";
    private final RepositorioInventario repositorioInventario;
    private final DaoProducto daoProducto;

    public ServicioCrearInventario(RepositorioInventario repositorioInventario, DaoProducto daoProducto) {
        this.repositorioInventario = repositorioInventario;
        this.daoProducto = daoProducto;
    }

    public long ejecutar(Inventario inventario){
        validarPreviaExisteciaProducto(inventario.getIdProducto());
        return  repositorioInventario.crear(inventario);
    }

    private void validarPreviaExisteciaProducto(Integer idProducto){
        if(!daoProducto.existeIdProducto(idProducto)){
            throw new ExcepcionSinDatos(NO_EXISTE_PRODUCTO);
        }
    }
}
