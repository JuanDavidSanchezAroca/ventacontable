package com.ventacontable.controlador.usuario.permiso;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.comando.usuario.usuario.manejador.ManejadorActualizarUsuario;
import com.ventacontable.comando.usuario.usuario.manejador.ManejadorCrearUsuario;
import com.ventacontable.comando.usuario.usuario.manejador.ManejadorValidarUsuarioPassword;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ComandoControladorUsuario {
    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorActualizarUsuario manejadorActualizarUsuario;
    private final ManejadorValidarUsuarioPassword manejadorValidarUsuarioPassword;

    public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario, ManejadorActualizarUsuario manejadorActualizarUsuario,
                                     ManejadorValidarUsuarioPassword manejadorValidarUsuarioPassword) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorActualizarUsuario = manejadorActualizarUsuario;
        this.manejadorValidarUsuarioPassword = manejadorValidarUsuarioPassword;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoUsuario comandoUsuario) {
        return new ComandoRespuesta<>(this.manejadorCrearUsuario.ejecutar(comandoUsuario));
    }

    @PutMapping("/{id}")
    public ComandoRespuesta<Integer> actualizar(@RequestBody ComandoUsuario comandoUsuario, @PathVariable Integer id) {
        return new ComandoRespuesta<>(this.manejadorActualizarUsuario.ejecutar(comandoUsuario, id));
    }

    @GetMapping()
    public ComandoRespuesta<Boolean> validarUsuarioPassword(@RequestBody ComandoUsuario comandoUsuario) {
        return new ComandoRespuesta<>(this.manejadorValidarUsuarioPassword.ejecutar(comandoUsuario));
    }
}
