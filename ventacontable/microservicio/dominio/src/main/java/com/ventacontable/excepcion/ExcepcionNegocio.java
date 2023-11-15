package com.ventacontable.excepcion;

public class ExcepcionNegocio extends RuntimeException{

    public ExcepcionNegocio(String mensaje){
        super(mensaje);
    }
}
