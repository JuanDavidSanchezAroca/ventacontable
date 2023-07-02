package com.ventacontable.comando.usuario.usuario.fabrica;

import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class UsuarioFabrica {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public Usuario ejecutar(ComandoUsuario comandoUsuario){
        String password = comandoUsuario.getPassword();
        if (password == null || password.isEmpty()) {
            password = generarPassword(10);
        }
        return new Usuario(comandoUsuario.getCorreo(), password);
    }

    public String generarPassword(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
