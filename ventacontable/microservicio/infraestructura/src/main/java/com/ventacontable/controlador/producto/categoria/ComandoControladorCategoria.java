package com.ventacontable.controlador.producto.categoria;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.producto.categoria.ComandoCategoria;
import com.ventacontable.comando.producto.categoria.manejador.ManejadorCrearCategoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class ComandoControladorCategoria {


    private final ManejadorCrearCategoria manejadorCrearCategoria;

    public ComandoControladorCategoria(ManejadorCrearCategoria manejadorCrearCategoria) {
        this.manejadorCrearCategoria = manejadorCrearCategoria;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoCategoria comandoCategoria) {
        return new ComandoRespuesta<>(this.manejadorCrearCategoria.ejecutar(comandoCategoria));
    }
}


