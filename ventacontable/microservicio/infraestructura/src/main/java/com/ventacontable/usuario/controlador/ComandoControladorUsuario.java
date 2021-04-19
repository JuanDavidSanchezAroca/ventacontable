package com.ventacontable.usuario.controlador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.usuario.comando.ComandoUsuario;
import com.ventacontable.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ventacontable.usuario.comando.manejador.ManejadorCrearUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorActualizarUsuario manejadorActualizarUsuario;

    @Autowired
    public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario,ManejadorActualizarUsuario manejadorActualizarUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorActualizarUsuario = manejadorActualizarUsuario;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuario comandoUsuario) {
        return manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @PutMapping
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody ComandoUsuario comandoUsuario){
        this.manejadorActualizarUsuario.ejecutar(comandoUsuario);
    }
}
