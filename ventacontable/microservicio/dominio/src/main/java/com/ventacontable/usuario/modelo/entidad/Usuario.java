package com.ventacontable.usuario.modelo.entidad;

import static com.ventacontable.dominio.ValidadorArgumento.validarRegex;
import static com.ventacontable.dominio.ValidadorArgumento.validarLongitudMinima;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Usuario {
    private static final String VALIDAR_CORREO = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final String CORREO_INVALIDO = "El correo no cumple con el formato correcto";
    private static final Integer LONGITUD_PASSWORD = 10;
    private static final String LONGITUD_PASSWORD_INVALIDA = "No cumple con la longitud minima en el password";

    private String usuario;
    private String password;

    public Usuario(String usuario, String password){
        validarRegex(usuario,VALIDAR_CORREO,CORREO_INVALIDO);
        validarLongitudMinima(password,LONGITUD_PASSWORD,LONGITUD_PASSWORD_INVALIDA);
        this.usuario = usuario;
        this.password = password;
    }
}
