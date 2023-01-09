package com.ventacontable.comando.usuario.permiso.manejador;

import com.ventacontable.comando.usuario.permiso.ComandoPermiso;
import com.ventacontable.comando.usuario.permiso.fabrica.PermisoFabrica;
import com.ventacontable.usuario.modelo.Permiso;
import com.ventacontable.usuario.servicio.permiso.ActualizarPermisoServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarPermiso {

    private final PermisoFabrica permisoFabrica;
    private final ActualizarPermisoServicio actualizarPermisoServicio;

    public ManejadorActualizarPermiso(PermisoFabrica permisoFabrica,
                                      ActualizarPermisoServicio actualizarPermisoServicio) {
        this.permisoFabrica = permisoFabrica;
        this.actualizarPermisoServicio = actualizarPermisoServicio;
    }

    @Transactional
    public Integer ejecutar(ComandoPermiso comando, Integer id) {
        Permiso permiso = this.permisoFabrica.ejecutar(comando);
        return this.actualizarPermisoServicio.ejecutar(permiso, id);
    }
}
