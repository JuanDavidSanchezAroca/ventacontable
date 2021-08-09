package com.ventacontable.producto.comando.manejador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.producto.comando.ComandoProducto;
import com.ventacontable.producto.comando.fabrica.FabricaProducto;
import com.ventacontable.producto.modelo.entidad.Producto;
import com.ventacontable.producto.servicio.ServicioActualizarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<Long>> {

    private final FabricaProducto fabricaProducto;
    private final ServicioActualizarProducto servicioActualizarProducto;

    public ManejadorActualizarProducto(FabricaProducto fabricaProducto, ServicioActualizarProducto servicioActualizarProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioActualizarProducto = servicioActualizarProducto;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoProducto comando) {
        Producto producto = this.fabricaProducto.crear(comando);
        return new ComandoRespuesta<>(this.servicioActualizarProducto.ejecutar(producto));
    }
}
