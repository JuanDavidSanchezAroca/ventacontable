package com.ventacontable.usuario.servicio.usuario;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.dao.DaoUsuario;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;

public class ActualizarUsuarioServicio {


    private static final String NO_EXISTE_USUARIO = "El usuario ingresado no existe";
    private static final String YA_EXISTE_NOMBRE = "El nombre del usuario ya existe";

    private final DaoUsuario daoUsuario;
    private final RepositorioUsuario repositorioUsuario;

    public ActualizarUsuarioServicio(DaoUsuario daoUsuario, RepositorioUsuario repositorioUsuario) {
        this.daoUsuario = daoUsuario;
        this.repositorioUsuario = repositorioUsuario;
    }

    public Integer ejecutar(Usuario usuario, Integer id) {
        validarPreviaExistenciaPorId(id);
        validarPreviaExistenciaPorNombre(usuario.getUsuario());
        return repositorioUsuario.actualizar(usuario, id);
    }

    private void validarPreviaExistenciaPorId(Integer id) {
        if (!daoUsuario.buscarId(id)) {
            throw new ExcepcionSinDatos(NO_EXISTE_USUARIO);
        }
    }

    private void validarPreviaExistenciaPorNombre(String nombre) {
        if (daoUsuario.buscarUsuario(nombre)) {
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE);
        }
    }
}
