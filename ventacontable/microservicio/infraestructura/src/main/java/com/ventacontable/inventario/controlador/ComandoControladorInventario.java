package com.ventacontable.inventario.controlador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.inventario.comando.ComandoInventario;
import com.ventacontable.inventario.comando.manejador.ManejadorActualizarInventario;
import com.ventacontable.inventario.comando.manejador.ManejadorCrearInventario;
import com.ventacontable.inventario.comando.manejador.ManejadorEliminarInventario;
import com.ventacontable.producto.comando.ComandoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventarios")
@Api(tags = { "Controlador comando inventario"})
public class ComandoControladorInventario {

    private final ManejadorCrearInventario manejadorCrearInventario;
    private final ManejadorActualizarInventario manejadorActualizarInventario;
    private final ManejadorEliminarInventario manejadorEliminarInventario;

    public ComandoControladorInventario(ManejadorCrearInventario manejadorCrearInventario,
                                        ManejadorActualizarInventario manejadorActualizarInventario,
                                        ManejadorEliminarInventario manejadorEliminarInventario) {
        this.manejadorCrearInventario = manejadorCrearInventario;
        this.manejadorActualizarInventario = manejadorActualizarInventario;
        this.manejadorEliminarInventario = manejadorEliminarInventario;
    }

    @PostMapping
    @ApiOperation("Crear inventario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoInventario comandoInventario) {
        return manejadorCrearInventario.ejecutar(comandoInventario);
    }

    @PutMapping
    @ApiOperation("Actualizar inventario")
    public ComandoRespuesta<Long> actualizar(@RequestBody ComandoInventario comandoInventario){
        return manejadorActualizarInventario.ejecutar(comandoInventario);
    }

    @DeleteMapping("/{idInventario}")
    @ApiOperation("Eliminar inventario")
    public ComandoRespuesta<Long> eliminar(@PathVariable Integer idInventario){
        return  manejadorEliminarInventario.ejecutar(idInventario);
    }
}
