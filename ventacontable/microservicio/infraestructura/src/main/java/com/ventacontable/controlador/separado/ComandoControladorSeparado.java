package com.ventacontable.controlador.separado;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.separado.ComandoSeparado;
import com.ventacontable.comando.separado.manejador.ManejadorCrearSeparado;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/separado")
public class ComandoControladorSeparado {

    private final ManejadorCrearSeparado manejadorCrearSeparado;

    public ComandoControladorSeparado(ManejadorCrearSeparado manejadorCrearSeparado){
        this.manejadorCrearSeparado = manejadorCrearSeparado;
    }
    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoSeparado comandoSeparado) {
        return new ComandoRespuesta<>(this.manejadorCrearSeparado.ejecutar(comandoSeparado));
    }
}
