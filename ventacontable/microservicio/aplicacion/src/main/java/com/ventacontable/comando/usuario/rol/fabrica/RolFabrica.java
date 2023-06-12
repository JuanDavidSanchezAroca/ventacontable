package com.ventacontable.comando.usuario.rol.fabrica;

import com.ventacontable.comando.usuario.rol.ComandoRol;
import com.ventacontable.usuario.modelo.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolFabrica {
    public Rol ejecutar(ComandoRol comandoRol){
        return new Rol(comandoRol.getNombre(), comandoRol.getDescripcion());
    }
}
