package com.ventacontable.usuario.servicio.usuario;

import com.ventacontable.usuario.modelo.entidad.UserDetailsImpl;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.dao.DaoUsuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class LoginUsuarioServicio implements UserDetailsService {
    private static final String NO_EXISTE_USUARIO = "El usuario ingresado no existe";
    private final DaoUsuario daoUsuario;

    private void validarPreviaExistenciaPorNombre(String nombre) {
        if (!daoUsuario.buscarUsuario(nombre)) {
            throw new UsernameNotFoundException(NO_EXISTE_USUARIO);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        validarPreviaExistenciaPorNombre(username);
        Usuario usuario = daoUsuario.buscarUsuarioByEmail(username);
        return new UserDetailsImpl(usuario);
    }
}
