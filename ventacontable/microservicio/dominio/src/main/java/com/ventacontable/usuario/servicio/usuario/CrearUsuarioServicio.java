package com.ventacontable.usuario.servicio.usuario;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.dao.DaoUsuario;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;

public class CrearUsuarioServicio {
    private static final String YA_EXISTE_USUARIO = "El usuario ingresado ya existe";
    private final RepositorioUsuario repositorioUsuario;
    private final DaoUsuario daoUsuario;

    public CrearUsuarioServicio(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.daoUsuario = daoUsuario;
    }

    public Integer ejecutar(Usuario usuario) {
        validarPreviaExistencia(usuario.getUsuario());
        return repositorioUsuario.registrar(usuario);
    }

    private void validarPreviaExistencia(String nombre) {
        if (daoUsuario.buscarUsuario(nombre)) {
            throw new ExcepcionDuplicidad(YA_EXISTE_USUARIO);
        }
    }
}
