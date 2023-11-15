package com.ventacontable.controlador.usuario.permiso;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.usuario.permiso.ComandoPermiso;
import com.ventacontable.comando.usuario.permiso.manejador.ManejadorActualizarPermiso;
import com.ventacontable.comando.usuario.permiso.manejador.ManejadorCrearPermiso;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permiso")
public class ComandoControladorPermiso {

    private final ManejadorCrearPermiso manejadorCrearPermiso;
    private final ManejadorActualizarPermiso manejadorActualizarPermiso;

    public ComandoControladorPermiso(ManejadorCrearPermiso manejadorCrearPermiso,
                                     ManejadorActualizarPermiso manejadorActualizarPermiso) {
        this.manejadorCrearPermiso = manejadorCrearPermiso;
        this.manejadorActualizarPermiso = manejadorActualizarPermiso;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoPermiso comandoPermiso) {
        return new ComandoRespuesta<>(this.manejadorCrearPermiso.ejecutar(comandoPermiso));
    }

    @PutMapping("/{id}")
    public ComandoRespuesta<Integer> actualizar(@RequestBody ComandoPermiso comandoPermiso,@PathVariable Integer id){
        return new ComandoRespuesta<>(this.manejadorActualizarPermiso.ejecutar(comandoPermiso,id));
    }
}