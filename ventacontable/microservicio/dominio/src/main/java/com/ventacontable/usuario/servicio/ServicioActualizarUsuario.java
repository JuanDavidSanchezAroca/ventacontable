package com.ventacontable.usuario.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarUsuario {

    public static final String EL_USUARIO_NO_EXISTE = "No existe el usuario ingresado";
    public static final String EL_CORREO_YA_EXISTE = "El correo ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Usuario usuario) {
        this.validarPreviaExistencia(usuario.getIdUsuario());
        this.validarCorreoExistente(usuario.getCorreo());
        this.repositorioUsuario.actualizar(usuario);
    }

    private void validarPreviaExistencia(int idUsuario) {
        boolean existe = this.repositorioUsuario.existeId(idUsuario);
        if (!existe) {
            throw new ExcepcionSinDatos(EL_USUARIO_NO_EXISTE);
        }
    }

    private void validarCorreoExistente(String correo){
        boolean existe = this.repositorioUsuario.existe(correo);
        if(existe){
            throw new ExcepcionDuplicidad(EL_CORREO_YA_EXISTE);
        }
    }
}
