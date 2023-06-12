package com.ventacontable.comando.usuario.rol.manejador;

import com.ventacontable.comando.usuario.rol.ComandoRol;
import com.ventacontable.comando.usuario.rol.fabrica.RolFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.usuario.modelo.Rol;
import com.ventacontable.usuario.servicio.rol.CrearRolServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRol implements ManejadorComandoRespuesta<ComandoRol, Long> {
    private final CrearRolServicio crearRolServicio;
    private final RolFabrica rolFabrica;

    public ManejadorCrearRol(CrearRolServicio crearRolServicio, RolFabrica rolFabrica) {
        this.crearRolServicio = crearRolServicio;
        this.rolFabrica = rolFabrica;
    }

    @Override
    public Long ejecutar(ComandoRol comando) {
        Rol rol = this.rolFabrica.ejecutar(comando);
        return this.crearRolServicio.ejecutar(rol);
    }
}
