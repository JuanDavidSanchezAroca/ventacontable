package com.ventacontable.controlador.producto;
import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.producto.ComandoProducto;
import com.ventacontable.comando.producto.manejador.ManejadorCrearProducto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;

    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoProducto comandoProducto) {
        return new ComandoRespuesta<>(this.manejadorCrearProducto.ejecutar(comandoProducto));
    }
}
