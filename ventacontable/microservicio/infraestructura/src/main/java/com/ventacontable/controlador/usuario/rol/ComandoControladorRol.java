package com.ventacontable.controlador.usuario.rol;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.usuario.rol.ComandoRol;
import com.ventacontable.comando.usuario.rol.manejador.ManejadorCrearRol;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class ComandoControladorRol {
    private final ManejadorCrearRol manejadorCrearRol;

    public ComandoControladorRol(ManejadorCrearRol manejadorCrearRol) {
        this.manejadorCrearRol = manejadorCrearRol;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRol comandoRol) {
        return new ComandoRespuesta<>(this.manejadorCrearRol.ejecutar(comandoRol));
    }
}
