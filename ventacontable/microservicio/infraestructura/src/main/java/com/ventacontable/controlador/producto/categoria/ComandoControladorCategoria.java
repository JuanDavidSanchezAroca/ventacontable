package com.ventacontable.controlador.producto.categoria;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.producto.categoria.ComandoCategoria;
import com.ventacontable.comando.producto.categoria.manejador.ManejadorActualizarCategoria;
import com.ventacontable.comando.producto.categoria.manejador.ManejadorCrearCategoria;
import com.ventacontable.producto.modelo.entidad.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                                                @PathVariable Integer id){
        return new ComandoRespuesta<>(this.manejadorActualizarCategoria.ejecutar(comandoCategoria, id));
    }

    @GetMapping
    public ComandoRespuesta<Categoria> consultarCategorias(){
        return new ComandoRespuesta<>(new Categoria("aa","daf"));
    }
}


