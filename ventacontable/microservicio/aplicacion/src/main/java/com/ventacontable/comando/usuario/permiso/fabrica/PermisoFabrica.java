package com.ventacontable.comando.usuario.permiso.fabrica;

import com.ventacontable.comando.usuario.permiso.ComandoPermiso;
import com.ventacontable.usuario.modelo.Permiso;
import org.springframework.stereotype.Component;

@Component
public class PermisoFabrica {

    public Permiso ejecutar(ComandoPermiso comandoPermiso){
        return new Permiso(comandoPermiso.getNombre());
    }
}
