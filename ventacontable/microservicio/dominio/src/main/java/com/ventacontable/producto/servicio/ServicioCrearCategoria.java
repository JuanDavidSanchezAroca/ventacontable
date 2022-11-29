package com.ventacontable.producto.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.producto.modelo.entidad.Categoria;
import com.ventacontable.producto.puerto.repositorio.RepositorioCategoria;

public class ServicioCrearCategoria {
    private static final String YA_EXISTE_NOMBRE_CATEGORIA = "El nombre ya se usa en una categoria";
    private final RepositorioCategoria repositorioCategoria;

    public ServicioCrearCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public long ejecutar(Categoria categoria) {
        this.validarExistenciaNombreCategoria(categoria.getNombre());
        return this.repositorioCategoria.crear(categoria);
    }

    private void validarExistenciaNombreCategoria(String nombreCategoria) {
        boolean existe = this.repositorioCategoria.existeNombreCategoria(nombreCategoria);
        if (existe) {
            throw new ExcepcionDuplicidad(YA_EXISTE_NOMBRE_CATEGORIA);
        }
    }
}
