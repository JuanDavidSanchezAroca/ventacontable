package com.ventacontable.producto.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import com.ventacontable.inventario.servicio.CrearInventarioServicio;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.puerto.repositorio.RepositorioProducto;
import com.ventacontable.categoria.servicio.AsociarCategoriaServicio;

import java.time.LocalDate;

public class CrearProductoServicio {

    private static final String YA_EXISTE_NOMBRE_PRODUCTO="Ya existe el nombre del producto";

    private final RepositorioProducto repositorioProducto;
    private final AsociarCategoriaServicio asociarCategoriaServicio;

    private final CrearInventarioServicio crearInventarioServicio;

    public CrearProductoServicio(RepositorioProducto repositorioProducto,
                                 AsociarCategoriaServicio asociarCategoriaServicio,
                                 CrearInventarioServicio crearInventarioServicio) {
        this.repositorioProducto = repositorioProducto;
        this.asociarCategoriaServicio = asociarCategoriaServicio;
        this.crearInventarioServicio = crearInventarioServicio;
    }

    public long ejecutar(Producto producto){
        this.validarPreviaExistenciaNombre(producto.getNombre());
        long id = this.repositorioProducto.crear(producto);
        if(!producto.getCategorias().isEmpty())
            asociarCategoriaServicio.ejecutar((int)id, producto.getCategorias());
        crearInventario(producto, id);
        return id;
    }

    private void validarPreviaExistenciaNombre(String nombre){
        boolean existe = this.repositorioProducto.existeNombre(nombre);
        if(existe){
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE_PRODUCTO);
        }
    }

    private void crearInventario(Producto producto, long idProducto){
        if(producto.getCantidadDisponible() > 0 ){
            this.crearInventarioServicio.ejecutar(
                    new Inventario(
                            null,
                            LocalDate.now(),
                            producto.getCantidadDisponible(),
                            (int)idProducto)
            );
        }
    }
}
