package com.ventacontable.usuario.servicio;

import com.ventacontable.excepcion.ExcepcionNegocio;
import com.ventacontable.usuario.modelo.Permiso;
import com.ventacontable.usuario.puerto.dao.DaoPermiso;
import com.ventacontable.usuario.puerto.repositorio.RepositorioPermiso;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CrearPermisoServicio {

    private static final String YA_EXISTE_PERMISO = "El permiso ingresado ya existe";
    private final RepositorioPermiso repositorioPermiso;
    private final DaoPermiso daoPermiso;

    public Integer ejecutar(Permiso permiso){
        validarPreviaExistencia(permiso.getNombre());
        return repositorioPermiso.registrar(permiso);
    }

    private void validarPreviaExistencia(String nombre){
        if(daoPermiso.buscar(nombre)){
            throw new ExcepcionNegocio(YA_EXISTE_PERMISO);
        }
    }
}
