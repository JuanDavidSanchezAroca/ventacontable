package com.ventacontable.usuario.servicio.usuario;

import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.dao.DaoUsuario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginUsuarioServicio {
    private static final String NO_EXISTE_USUARIO = "El usuario ingresado no existe";
    private static final String PASS_INCORRECTA = "La password ingresada no es correcta";
    private final DaoUsuario daoUsuario;

    public boolean ejecutar(Usuario usuario) {
        validarPreviaExistenciaPorNombre(usuario.getUsuario());
        validarPassword(usuario);
        return true;
    }

    private void validarPreviaExistenciaPorNombre(String nombre) {
        if (!daoUsuario.buscarUsuario(nombre)) {
            throw new ExcepcionSinDatos(NO_EXISTE_USUARIO);
        }
    }

    private void validarPassword(Usuario usuario) {
        if (!daoUsuario.validarUsuarioPassword(usuario)) {
            throw new ExcepcionSinDatos(PASS_INCORRECTA);
        }
    }

}
