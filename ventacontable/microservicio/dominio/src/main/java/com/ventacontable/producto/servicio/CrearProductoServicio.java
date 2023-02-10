package com.ventacontable.producto.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.puerto.repositorio.RepositorioProducto;
import com.ventacontable.categoria.servicio.AsociarCategoriaServicio;

public class CrearProductoServicio {

    private static final String YA_EXISTE_NOMBRE_PRODUCTO="Ya existe el nombre del producto";

    private final RepositorioProducto repositorioProducto;
    private final AsociarCategoriaServicio asociarCategoriaServicio;

    public CrearProductoServicio(RepositorioProducto repositorioProducto,
                                 AsociarCategoriaServicio asociarCategoriaServicio) {
        this.repositorioProducto = repositorioProducto;
        this.asociarCategoriaServicio = asociarCategoriaServicio;
    }

    public long ejecutar(Producto producto){
        this.validarPreviaExistenciaNombre(producto.getNombre());
        long id = this.repositorioProducto.crear(producto);
        asociarCategoriaServicio.ejecutar((int)id,producto.getCategorias());
        return id;
    }

    private void validarPreviaExistenciaNombre(String nombre){
        boolean existe = this.repositorioProducto.existeNombre(nombre);
        if(existe){
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE_PRODUCTO);
        }
    }
}
