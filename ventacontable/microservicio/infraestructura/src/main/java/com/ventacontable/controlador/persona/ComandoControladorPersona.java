package com.ventacontable.controlador.persona;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.comando.persona.manejador.ManejadorActualizarPersona;
import com.ventacontable.comando.persona.manejador.ManejadorCrearPersona;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ComandoControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorActualizarPersona manejadorActualizarPersona;

    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona, ManejadorActualizarPersona manejadorActualizarPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorActualizarPersona = manejadorActualizarPersona;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoPersona comandoPersona) {
        return new ComandoRespuesta<>(this.manejadorCrearPersona.ejecutar(comandoPersona));
    }

    @PutMapping
    public ComandoRespuesta<String> actualizar(@RequestBody ComandoPersona comandoPersona) {
        return new ComandoRespuesta<>(this.manejadorActualizarPersona.ejecutar(comandoPersona));
    }
}
