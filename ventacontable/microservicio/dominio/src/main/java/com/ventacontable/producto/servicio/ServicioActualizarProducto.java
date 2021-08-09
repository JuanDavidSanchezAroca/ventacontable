package com.ventacontable.producto.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionValorInvalido;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.puerto.dao.DaoProducto;
import com.ventacontable.producto.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarProducto {

    private static final String NO_EXISTE_PRODUCTO="El producto ingresado no existe";

    private final DaoProducto daoProducto;
    private final RepositorioProducto repositorioProducto;

    public ServicioActualizarProducto(DaoProducto daoProducto,RepositorioProducto repositorioProducto){
        this.daoProducto=daoProducto;
        this.repositorioProducto = repositorioProducto;
    }

    public long ejecutar(Producto producto){
        buscarProducto(producto.getIdProducto());
        this.repositorioProducto.actualizar(producto);
        return producto.getIdProducto();
    }

    private void buscarProducto(int idProducto){
        if(!daoProducto.existeIdProducto(idProducto)){
            throw new ExcepcionValorInvalido(NO_EXISTE_PRODUCTO);
        }
    }

}
