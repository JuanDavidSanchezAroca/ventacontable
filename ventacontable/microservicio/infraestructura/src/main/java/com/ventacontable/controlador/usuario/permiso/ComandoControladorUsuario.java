package com.ventacontable.controlador.usuario.permiso;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.usuario.permiso.ComandoPermiso;
import com.ventacontable.comando.usuario.permiso.manejador.ManejadorActualizarPermiso;
import com.ventacontable.comando.usuario.permiso.manejador.ManejadorCrearPermiso;
import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.comando.usuario.usuario.manejador.ManejadorActualizarUsuario;
import com.ventacontable.comando.usuario.usuario.manejador.ManejadorCrearUsuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ComandoControladorUsuario {
    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorActualizarUsuario manejadorActualizarUsuario;

    public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario, ManejadorActualizarUsuario manejadorActualizarUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorActualizarUsuario = manejadorActualizarUsuario;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoUsuario comandoUsuario) {
        return new ComandoRespuesta<>(this.manejadorCrearUsuario.ejecutar(comandoUsuario));
    }

    @PutMapping("/{id}")
    public ComandoRespuesta<Integer> actualizar(@RequestBody ComandoUsuario comandoUsuario, @PathVariable Integer id) {
        return new ComandoRespuesta<>(this.manejadorActualizarUsuario.ejecutar(comandoUsuario, id));
    }
}
