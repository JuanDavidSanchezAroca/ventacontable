package com.ventacontable.controlador.persona;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.comando.persona.manejador.ManejadorCrearPersona;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ComandoControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;

    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoPersona comandoPersona) {
        return new ComandoRespuesta<>(this.manejadorCrearPersona.ejecutar(comandoPersona));
    }
}
