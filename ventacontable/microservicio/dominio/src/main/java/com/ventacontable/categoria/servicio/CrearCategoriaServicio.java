package com.ventacontable.categoria.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.categoria.modelo.Categoria;
import com.ventacontable.categoria.puerto.dao.DaoCategoria;
import com.ventacontable.categoria.puerto.repositorio.RepositorioCategoria;

public class CrearCategoriaServicio {
    private static final String YA_EXISTE_NOMBRE_CATEGORIA = "El nombre ya se usa en una categoria";
    private final RepositorioCategoria repositorioCategoria;
    private final DaoCategoria daoCategoria;

    public CrearCategoriaServicio(RepositorioCategoria repositorioCategoria, DaoCategoria daoCategoria) {
        this.repositorioCategoria = repositorioCategoria;
        this.daoCategoria = daoCategoria;
    }

    public int ejecutar(Categoria categoria) {
        this.validarExistenciaNombreCategoria(categoria.getNombre());
        return this.repositorioCategoria.crear(categoria);
    }

    private void validarExistenciaNombreCategoria(String nombreCategoria) {
        boolean existe = this.daoCategoria.existeNombreCategoria(nombreCategoria);
        if (existe) {
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE_CATEGORIA);
        }
    }
}
