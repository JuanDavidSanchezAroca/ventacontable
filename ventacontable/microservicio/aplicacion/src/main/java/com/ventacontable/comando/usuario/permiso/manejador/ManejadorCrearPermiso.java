package com.ventacontable.comando.usuario.permiso.manejador;

import com.ventacontable.comando.usuario.permiso.ComandoPermiso;
import com.ventacontable.comando.usuario.permiso.fabrica.PermisoFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.usuario.modelo.Permiso;
import com.ventacontable.usuario.servicio.CrearPermisoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPermiso implements ManejadorComandoRespuesta<ComandoPermiso, Integer> {

    private final CrearPermisoServicio crearPermisoServicio;
    private final PermisoFabrica permisoFabrica;

    public ManejadorCrearPermiso(CrearPermisoServicio crearPermisoServicio, PermisoFabrica permisoFabrica) {
        this.crearPermisoServicio = crearPermisoServicio;
        this.permisoFabrica = permisoFabrica;
    }

    @Override
    public Integer ejecutar(ComandoPermiso comandoPermiso) {
        Permiso permiso = this.permisoFabrica.ejecutar(comandoPermiso);
        return this.crearPermisoServicio.ejecutar(permiso);
    }

}
