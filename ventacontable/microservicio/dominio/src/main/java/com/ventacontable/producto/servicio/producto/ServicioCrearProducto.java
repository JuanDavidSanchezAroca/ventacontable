package com.ventacontable.producto.servicio.producto;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.puerto.repositorio.RepositorioProducto;

public class ServicioCrearProducto {

    private static final String YA_EXISTE_NOMBRE_PRODUCTO="Ya existe el nombre del producto";

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public long ejecutar(Producto producto){
        this.validarPreviaExistenciaNombre(producto.getNombre());
        return this.repositorioProducto.crear(producto);
    }

    private void validarPreviaExistenciaNombre(String nombre){
        boolean existe = this.repositorioProducto.existeNombre(nombre);
        if(existe){
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE_PRODUCTO);
        }
    }
}
