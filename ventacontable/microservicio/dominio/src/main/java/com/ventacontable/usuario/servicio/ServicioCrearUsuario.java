package com.ventacontable.usuario.servicio;

import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;
import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario);
        return this.repositorioUsuario.crear(usuario);
    }

    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existe(usuario.getCorreo());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
