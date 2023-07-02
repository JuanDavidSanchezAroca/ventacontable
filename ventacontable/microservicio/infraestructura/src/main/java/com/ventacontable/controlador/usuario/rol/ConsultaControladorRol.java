package com.ventacontable.controlador.usuario.rol;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.comando.usuario.rol.ComandoRol;
import com.ventacontable.comando.usuario.rol.manejador.ManejadorListarRol;
import com.ventacontable.usuario.modelo.dto.DtoRol;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class ConsultaControladorRol {

    private final ManejadorListarRol manejadorListarRol;

    public ConsultaControladorRol(ManejadorListarRol manejadorListarRol) {
        this.manejadorListarRol = manejadorListarRol;
    }

    @GetMapping
    public ComandoRespuesta<List<DtoRol>> listar() {
        return new ComandoRespuesta<>(this.manejadorListarRol.ejecutar());
    }
}
