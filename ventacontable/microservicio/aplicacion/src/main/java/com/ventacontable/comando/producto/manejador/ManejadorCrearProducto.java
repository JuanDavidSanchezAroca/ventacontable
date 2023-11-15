package com.ventacontable.comando.producto.manejador;

import com.ventacontable.comando.producto.ComandoProducto;
import com.ventacontable.comando.producto.fabrica.FabricaProducto;
import com.ventacontable.inventario.servicio.CrearInventarioServicio;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.servicio.CrearProductoServicio;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, Integer> {
    private final FabricaProducto fabricaProducto;
    private final CrearProductoServicio crearProductoServicio;


    public ManejadorCrearProducto(FabricaProducto fabricaProducto,
                                  CrearProductoServicio crearProductoServicio) {
        this.fabricaProducto = fabricaProducto;
        this.crearProductoServicio = crearProductoServicio;
    }

    @Override
    public Integer ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        return (int)this.crearProductoServicio.ejecutar(producto);
    }
}
