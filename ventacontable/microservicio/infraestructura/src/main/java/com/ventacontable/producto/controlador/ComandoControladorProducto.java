package com.ventacontable.producto.controlador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.producto.comando.ComandoProducto;
import com.ventacontable.producto.comando.manejador.ManejadorActualizarProducto;
import com.ventacontable.producto.comando.manejador.ManejadorCrearProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador comando producto"})
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorActualizarProducto manjeadorActualizarProducto;

    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto,
                                        ManejadorActualizarProducto manejadorActualizarProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manjeadorActualizarProducto = manejadorActualizarProducto;
    }

    @PostMapping
    @ApiOperation("Crear producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @PutMapping
    @ApiOperation("Actualizar producto")
    public ComandoRespuesta<Long> actualizar(@RequestBody ComandoProducto comandoProducto){
        return manjeadorActualizarProducto.ejecutar(comandoProducto);
    }
}
