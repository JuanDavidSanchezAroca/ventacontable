package com.ventacontable.inventario.comando.manejador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.inventario.comando.ComandoInventario;
import com.ventacontable.inventario.comando.fabrica.FabricaInventario;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import com.ventacontable.inventario.servicio.ServicioActualizarInventario;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarInventario implements ManejadorComandoRespuesta<ComandoInventario, ComandoRespuesta<Long>>  {

    private final FabricaInventario fabricaInventario;
    private final ServicioActualizarInventario servicioActualizarInventario;

    public ManejadorActualizarInventario(FabricaInventario fabricaInventario, ServicioActualizarInventario servicioActualizarInventario) {
        this.fabricaInventario = fabricaInventario;
        this.servicioActualizarInventario = servicioActualizarInventario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoInventario comando) {
        Inventario inventario = this.fabricaInventario.crear(comando);
        return new ComandoRespuesta<>(this.servicioActualizarInventario.ejecutar(inventario));
    }
}
