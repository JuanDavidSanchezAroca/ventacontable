package com.ventacontable.controlador.categoria;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.categoria.modelo.dto.DtoCategoria;
import com.ventacontable.comando.categoria.manejador.ManejadorListarCategorias;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class ConsultaControladorCategoria {
    private final ManejadorListarCategorias manejadorListarCategorias;

    public ConsultaControladorCategoria(ManejadorListarCategorias manejadorListarCategorias) {
        this.manejadorListarCategorias = manejadorListarCategorias;
    }


    @GetMapping
    public ComandoRespuesta<List<DtoCategoria>> listarCategorias(){
        return new ComandoRespuesta<>(this.manejadorListarCategorias.ejecutar());
    }
}
