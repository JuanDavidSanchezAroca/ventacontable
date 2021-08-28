package com.ventacontable.producto.controlador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.producto.consulta.ManejadorListarProducto;
import com.ventacontable.producto.consulta.ManejadorObtenerProducto;
import com.ventacontable.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador consulta producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProducto manejadorListarProducto;
    private final ManejadorObtenerProducto manejadorObtenerProducto;

    public ConsultaControladorProducto(ManejadorListarProducto manejadorListarProducto,
                                        ManejadorObtenerProducto manejadorObtenerProducto) {
        this.manejadorListarProducto = manejadorListarProducto;
        this.manejadorObtenerProducto= manejadorObtenerProducto;
    }

    @GetMapping
    @ApiOperation("listar productos")
    public ComandoRespuesta<DtoProducto> listar(){
        return manejadorListarProducto.ejecutar();
    }

    @GetMapping("/{idProducto}")
    public ComandoRespuesta<DtoProducto> obtener(@PathVariable Integer idProducto){
        return manejadorObtenerProducto.ejecutar(idProducto);
    }
}
