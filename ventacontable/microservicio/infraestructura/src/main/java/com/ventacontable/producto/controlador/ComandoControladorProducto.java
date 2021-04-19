package com.ventacontable.producto.controlador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.producto.comando.ComandoProducto;
import com.ventacontable.producto.comando.manejador.ManejadorCrearProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador comando producto"})
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;

    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
    }

    @PostMapping
    @ApiOperation("Crear producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }
}
