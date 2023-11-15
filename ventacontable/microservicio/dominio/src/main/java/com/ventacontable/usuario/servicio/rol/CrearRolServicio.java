package com.ventacontable.usuario.servicio.rol;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.usuario.modelo.entidad.Rol;
import com.ventacontable.usuario.puerto.dao.DaoRol;
import com.ventacontable.usuario.puerto.repositorio.RepositorioRol;

public class CrearRolServicio {

    private final static String YA_EXISTE_ROL = "El rol ya existe";

    private final DaoRol daoRol;
    private final RepositorioRol repositorioRol;
    public CrearRolServicio(DaoRol daoRol, RepositorioRol repositorioRol){
        this.daoRol = daoRol;
        this.repositorioRol = repositorioRol;
    }

    public Long ejecutar(Rol rol){
        validarPreviaExistenciaPorNombre(rol.getNombre());
        return repositorioRol.registrar(rol);
    }

    private void validarPreviaExistenciaPorNombre(String nombre){
        if(daoRol.buscarNombre(nombre)){
            throw new ExcepcionDuplicidad(YA_EXISTE_ROL);
        }
    }
}
