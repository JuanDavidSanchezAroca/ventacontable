package com.ventacontable.categoria.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.categoria.modelo.Categoria;
import com.ventacontable.categoria.puerto.dao.DaoCategoria;
import com.ventacontable.categoria.puerto.repositorio.RepositorioCategoria;

public class ActualizarCategoriaServicio {
    public static final String YA_EXISTE_NOMBRE_CATEGORIA = "Ya existe otra categoria con este nombre";
    public static final String NO_EXISTE_ID_CATEGORIA = "No se encontro categoria con el id ingresado";
    private final RepositorioCategoria repositorioCategoria;
    private final DaoCategoria daoCategoria;

    public ActualizarCategoriaServicio(RepositorioCategoria repositorioCategoria, DaoCategoria daoCategoria){
        this.repositorioCategoria=repositorioCategoria;
        this.daoCategoria = daoCategoria;
    }

    public int ejecutar(Categoria categoria, Integer idCategoria){
        this.validarIdCategoriaExiste(idCategoria);
        this.validarExistenciaNombreEnOtraCategoria(categoria.getNombre(), idCategoria);
        return this.repositorioCategoria.actualizar(categoria, idCategoria);
    }

    private void validarExistenciaNombreEnOtraCategoria(String nombreCategoria, Integer idCategoria){
        boolean existe = daoCategoria.existeNombreCategoria(idCategoria, nombreCategoria);
        if (existe)
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE_CATEGORIA);
    }

    private void validarIdCategoriaExiste(Integer idCategoria){
        boolean existe = daoCategoria.existeIdCategoria(idCategoria);
        if (!existe){
            throw new ExcepcionSinDatos(NO_EXISTE_ID_CATEGORIA);
        }
    }
}
