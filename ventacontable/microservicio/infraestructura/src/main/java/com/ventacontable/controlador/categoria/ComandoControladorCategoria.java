package com.ventacontable.controlador.categoria;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.categoria.ComandoCategoria;
import com.ventacontable.comando.categoria.manejador.ManejadorActualizarCategoria;
import com.ventacontable.comando.categoria.manejador.ManejadorCrearCategoria;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/categoria")
public class ComandoControladorCategoria {


    private final ManejadorCrearCategoria manejadorCrearCategoria;
    private final ManejadorActualizarCategoria manejadorActualizarCategoria;

    public ComandoControladorCategoria(ManejadorCrearCategoria manejadorCrearCategoria,
                                       ManejadorActualizarCategoria manejadorActualizarCategoria) {
        this.manejadorCrearCategoria = manejadorCrearCategoria;
        this.manejadorActualizarCategoria = manejadorActualizarCategoria;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoCategoria comandoCategoria) {
        return new ComandoRespuesta<>(this.manejadorCrearCategoria.ejecutar(comandoCategoria));
    }

    @PutMapping("/{id}")
    public ComandoRespuesta<Integer> actualizar(@RequestBody ComandoCategoria comandoCategoria,
                                                @PathVariable Integer id) {
        return new ComandoRespuesta<>(this.manejadorActualizarCategoria.ejecutar(comandoCategoria, id));
    }
}


