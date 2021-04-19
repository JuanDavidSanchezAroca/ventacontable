package com.ventacontable.usuario.modelo.entidad;


import lombok.Getter;

import static com.ventacontable.dominio.ValidadorArgumento.validarLongitud;
import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_CORREO_DE_USUARIO = "Se debe ingresar el correo de usuario";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private int idUsuario;
    private String nombreCompleto;
    private String password;
    private String correo;
    private String imagen;

    public Usuario(int idUsuario,String nombreCompleto, String password, String correo, String imagen) {
        validarObligatorio(nombreCompleto, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(password, SE_DEBE_INGRESAR_LA_CLAVE);
        validarLongitud(password, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        validarObligatorio(correo, SE_DEBE_INGRESAR_CORREO_DE_USUARIO);
        this.idUsuario=idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.correo = correo;
        this.imagen = imagen;
    }

}
