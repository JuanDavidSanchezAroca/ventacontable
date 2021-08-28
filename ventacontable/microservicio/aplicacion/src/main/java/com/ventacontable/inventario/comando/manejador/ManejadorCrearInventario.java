package com.ventacontable.inventario.comando.manejador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.inventario.comando.ComandoInventario;
import com.ventacontable.inventario.comando.fabrica.FabricaInventario;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import com.ventacontable.inventario.servicio.ServicioCrearInventario;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearInventario implements ManejadorComandoRespuesta<ComandoInventario, ComandoRespuesta<Long>> {

    private final FabricaInventario fabricaInventario;
    private final ServicioCrearInventario servicioCrearInventario;

    public ManejadorCrearInventario(FabricaInventario fabricaInventario, ServicioCrearInventario servicioCrearInventario) {
        this.fabricaInventario = fabricaInventario;
        this.servicioCrearInventario = servicioCrearInventario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoInventario comando) {
        Inventario inventario = this.fabricaInventario.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearInventario.ejecutar(inventario));
    }
}
