package com.ventacontable.usuario.servicio.permiso;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.usuario.modelo.Permiso;
import com.ventacontable.usuario.puerto.dao.DaoPermiso;
import com.ventacontable.usuario.puerto.repositorio.RepositorioPermiso;

public class ActualizarPermisoServicio {
    private static final String NO_EXISTE_PERMISO = "El permiso ingresado no existe";
    private static final String YA_EXISTE_NOMBRE = "El nombre del permiso ya existe";

    private final DaoPermiso daoPermiso;
    private final RepositorioPermiso repositorioPermiso;

    public ActualizarPermisoServicio(DaoPermiso daoPermiso, RepositorioPermiso repositorioPermiso){
        this.daoPermiso = daoPermiso;
        this.repositorioPermiso = repositorioPermiso;
    }

    public Integer ejecutar(Permiso permiso, Integer id){
        validarPreviaExistenciaPorId(id);
        validarPreviaExistenciaPorNombre(permiso.getNombre());
        Permiso permisoActualizar = new Permiso(permiso.getNombre(), id);
        return repositorioPermiso.actualizar(permisoActualizar);
    }

    private void validarPreviaExistenciaPorId(Integer id){
        if(!daoPermiso.buscarId(id)){
            throw new ExcepcionSinDatos(NO_EXISTE_PERMISO);
        }
    }

    private void validarPreviaExistenciaPorNombre(String nombre){
        if(daoPermiso.buscarNombre(nombre)){
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE);
        }
    }
}
