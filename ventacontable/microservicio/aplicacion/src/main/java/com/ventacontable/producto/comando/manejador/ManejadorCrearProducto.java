package com.ventacontable.producto.comando.manejador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.producto.comando.ComandoProducto;
import com.ventacontable.producto.comando.fabrica.FabricaProducto;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.servicio.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<Long>> {

    private final FabricaProducto fabricaProducto;
    private final ServicioCrearProducto servicioCrearProducto;

    public ManejadorCrearProducto(FabricaProducto fabricaProducto, ServicioCrearProducto servicioCrearProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioCrearProducto = servicioCrearProducto;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoProducto comando) {
        Producto producto= this.fabricaProducto.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearProducto.ejecutar(producto));
    }
}
