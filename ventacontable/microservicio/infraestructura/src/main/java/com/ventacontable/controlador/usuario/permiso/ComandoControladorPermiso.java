package com.ventacontable.controlador.usuario.permiso;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.usuario.permiso.ComandoPermiso;
import com.ventacontable.comando.usuario.permiso.manejador.ManejadorCrearPermiso;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permiso")
public class ComandoControladorPermiso {

    private final ManejadorCrearPermiso manejadorCrearPermiso;

    public ComandoControladorPermiso(ManejadorCrearPermiso manejadorCrearPermiso) {
        this.manejadorCrearPermiso = manejadorCrearPermiso;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoPermiso comandoPermiso) {
        return  new ComandoRespuesta<>(this.manejadorCrearPermiso.ejecutar(comandoPermiso));
    }
}