package com.ventacontable.controlador.persona;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.persona.ComandoPersona;
import com.ventacontable.comando.persona.manejador.ManejadorCrearPersona;
import com.ventacontable.comando.producto.categoria.ComandoCategoria;
import com.ventacontable.comando.producto.categoria.manejador.ManejadorActualizarCategoria;
import com.ventacontable.comando.producto.categoria.manejador.ManejadorCrearCategoria;
import com.ventacontable.producto.modelo.entidad.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/persona")
public class ComandoControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;

    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
    }

    @PostMapping
    public Object crear(@RequestBody ComandoPersona comandoPersona) {

        System.out.println(comandoPersona.getTipoDocumento());
        try {
            return new ComandoRespuesta<>(this.manejadorCrearPersona.ejecutar(comandoPersona));

        }catch (Error e){
            return e;
        }
    }
}
