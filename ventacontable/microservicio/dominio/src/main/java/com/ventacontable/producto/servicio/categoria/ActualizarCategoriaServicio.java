package com.ventacontable.producto.servicio.categoria;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.producto.modelo.entidad.Categoria;
import com.ventacontable.producto.puerto.dao.DaoCategoria;
import com.ventacontable.producto.puerto.repositorio.RepositorioCategoria;

public class ActualizarCategoriaServicio {
    public static final String YA_EXISTE_NOMBRE_CATEGORIA = "Ya existe otra categoria con este nombre";
    private final RepositorioCategoria repositorioCategoria;
    private final DaoCategoria daoCategoria;

    public ActualizarCategoriaServicio(RepositorioCategoria repositorioCategoria, DaoCategoria daoCategoria){
        this.repositorioCategoria=repositorioCategoria;
        this.daoCategoria = daoCategoria;
    }

    public int ejecutar(Categoria categoria, Integer idCategoria){
        this.validarExistenciaNombreEnOtraCategoria(categoria.getNombre(), idCategoria);
        return this.repositorioCategoria.actualizar(categoria, idCategoria);
    }

    private void validarExistenciaNombreEnOtraCategoria(String nombreCategoria, Integer idCategoria){
        boolean existe = daoCategoria.existeNombreCategoria(idCategoria, nombreCategoria);
        if (existe)
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE_CATEGORIA);
    }
}
