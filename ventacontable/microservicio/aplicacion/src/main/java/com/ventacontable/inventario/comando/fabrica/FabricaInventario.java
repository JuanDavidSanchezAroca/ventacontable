package com.ventacontable.inventario.comando.fabrica;

import com.ventacontable.inventario.comando.ComandoInventario;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import org.springframework.stereotype.Component;

@Component
public class FabricaInventario {

    public Inventario crear(ComandoInventario comandoInventario){
        return new Inventario(comandoInventario.getCodigo(),
                comandoInventario.getFechaIngreso(),
                comandoInventario.getCantidad(),
                comandoInventario.getDisponible(),
                comandoInventario.getIdProducto());
    }
}
