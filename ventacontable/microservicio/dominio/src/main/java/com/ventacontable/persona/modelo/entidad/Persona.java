package com.ventacontable.persona.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ventacontable.dominio.ValidadorArgumento.*;

@Getter
public class Persona {

    private static final String IDENTIFICACION_OBLIGATORIA = "Se debe ingresar identificacion";
    private static final String NOMBRE_OBLIGATORIO = "Se debe ingresar nombre";
    private static final String APELLIDO_OBLIGATORIO = "Se debe ingresar apellido";
    private static final String TIPO_DOCUMENTO_OBLIGATORIO = "Se debe ingresar 'tipoDocumento'";
    private static final String TIPO_DOCUMENTO_INCORRECTO = "Tipo documento invalido, valores permitidos: CC, TI, PASS, CE, NIP, NIT";
    private static final String GENERO_INCORRECTO = "Genero Invalido, valores permitidos: MASCULINO, FEMENINO";
    private static final String TELEFONO_OBLIGATORIO = "Se debe ingresar telefono";
    private static final String GENERO_OBLIGATORIO = "Se debe ingresar genero";
    private static final String DIRECCION_OBLIGATORIA = "Se debe ingresar direccion";

    private String identificacion;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private TipoDocumento tipoDocumento;
    private String telefono;
    private Genero genero;
    private String direccion;
    private Integer usuario;
    private Integer rol;

    public Persona(String identificacion, String nombre, String apellido,
                   String tipoDocumento, String telefono,
                   String genero, String direccion, LocalDate fechaNacimiento,
                   Integer rol, Integer usuario) {
        validarObligatorio(identificacion, IDENTIFICACION_OBLIGATORIA);
        validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
        validarObligatorio(apellido, APELLIDO_OBLIGATORIO);
        validarObligatorio(tipoDocumento, TIPO_DOCUMENTO_OBLIGATORIO);
        validarObligatorio(telefono, TELEFONO_OBLIGATORIO);
        validarObligatorio(genero, GENERO_OBLIGATORIO);
        validarObligatorio(direccion, DIRECCION_OBLIGATORIA);
        validarValido(tipoDocumento, TipoDocumento.class, TIPO_DOCUMENTO_INCORRECTO);
        validarValido(genero, Genero.class, GENERO_INCORRECTO);

        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = TipoDocumento.valueOf(tipoDocumento);
        this.telefono = telefono;
        this.genero = Genero.valueOf(genero);
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.rol = rol;
    }
}
