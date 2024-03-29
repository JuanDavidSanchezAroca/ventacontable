package com.ventacontable.controlador.categoria;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.categoria.modelo.dto.DtoCategoria;
import com.ventacontable.comando.categoria.ComandoCategoria;
import com.ventacontable.comando.categoria.manejador.ManejadorActualizarCategoria;
import com.ventacontable.comando.categoria.manejador.ManejadorCrearCategoria;
import com.ventacontable.comando.categoria.manejador.ManejadorListarCategorias;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class ComandoControladorCategoria {


    private final ManejadorCrearCategoria manejadorCrearCategoria;
    private final ManejadorActualizarCategoria manejadorActualizarCategoria;


    public ComandoControladorCategoria(ManejadorCrearCategoria manejadorCrearCategoria,
                                       ManejadorActualizarCategoria manejadorActualizarCategoria,
                                       ManejadorListarCategorias manejadorListarCategorias) {
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


