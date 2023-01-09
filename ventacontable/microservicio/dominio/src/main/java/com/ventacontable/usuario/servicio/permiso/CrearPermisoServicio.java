package com.ventacontable.usuario.servicio.permiso;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.usuario.modelo.Permiso;
import com.ventacontable.usuario.puerto.dao.DaoPermiso;
import com.ventacontable.usuario.puerto.repositorio.RepositorioPermiso;


public class CrearPermisoServicio {

    private static final String YA_EXISTE_PERMISO = "El permiso ingresado ya existe";
    private final RepositorioPermiso repositorioPermiso;
    private final DaoPermiso daoPermiso;

    public CrearPermisoServicio(RepositorioPermiso repositorioPermiso, DaoPermiso daoPermiso) {
        this.repositorioPermiso = repositorioPermiso;
        this.daoPermiso = daoPermiso;
    }

    public Integer ejecutar(Permiso permiso) {
        validarPreviaExistencia(permiso.getNombre());
        return repositorioPermiso.registrar(permiso);
    }

    private void validarPreviaExistencia(String nombre) {
        if (daoPermiso.buscarNombre(nombre)) {
            throw new ExcepcionDuplicidad(YA_EXISTE_PERMISO);
        }
    }
}
