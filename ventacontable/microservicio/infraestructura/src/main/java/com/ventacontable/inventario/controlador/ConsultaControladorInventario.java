package com.ventacontable.inventario.controlador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.inventario.consulta.ManejadorListarInventario;
import com.ventacontable.inventario.consulta.ManejadorObtenerInventarioPorProducto;
import com.ventacontable.inventario.modelo.dto.DtoInventario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventarios")
@Api(tags = { "Controlador consulta inventario"})
public class ConsultaControladorInventario {


    private final ManejadorListarInventario manejadorListarInventario;
    private final ManejadorObtenerInventarioPorProducto manejadorObtenerInventario;

    public ConsultaControladorInventario(ManejadorListarInventario manejadorListarInventario, ManejadorObtenerInventarioPorProducto manejadorObtenerInventario) {
        this.manejadorListarInventario = manejadorListarInventario;
        this.manejadorObtenerInventario = manejadorObtenerInventario;
    }

    @GetMapping
    @ApiOperation("listar inventarios")
    public ComandoRespuesta<DtoInventario> listar(){
        return manejadorListarInventario.ejecutar();
    }

    @GetMapping("/productos/{idProducto}")
    public ComandoRespuesta<DtoInventario> obtener(@PathVariable Integer idProducto){
        return manejadorObtenerInventario.ejecutar(idProducto);
    }
}
