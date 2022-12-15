package com.ventacontable.separado.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.separado.modelo.Separado;
import com.ventacontable.separado.puerto.repositorio.RepositorioSeparado;
import com.ventacontable.usuario.puerto.dao.DaoPersona;

public class CrearSeparadoServicio {

    private static final String NO_EXISTE_VENDEDOR = "El vendedor no existe";
    private static final String NO_EXISTE_COMPRADOR = "El comprador no existe";
    private final RepositorioSeparado  repositorioSeparado;
    private final DaoPersona daoPersona;

    public CrearSeparadoServicio(RepositorioSeparado repositorioSeparado, DaoPersona daoPersona){
        this.repositorioSeparado = repositorioSeparado;
        this.daoPersona = daoPersona;
    }

    public Integer Ejecutar (Separado separado){
        this.validarExistenciaVendedor(separado.getVendedor());
        this.validarExistenciaComprador(separado.getComprador());
        return this.repositorioSeparado.crear(separado);
    }

    private void validarExistenciaVendedor(Integer idVendedor){
        boolean existe = this.daoPersona.existePersona(idVendedor);
        if(!existe){
            throw new ExcepcionSinDatos(NO_EXISTE_VENDEDOR);
        }
    }
    private void validarExistenciaComprador(Integer idComprador){
        boolean existe = this.daoPersona.existePersona(idComprador);
        if(!existe){
            throw new ExcepcionSinDatos(NO_EXISTE_COMPRADOR);
        }
    }
}
