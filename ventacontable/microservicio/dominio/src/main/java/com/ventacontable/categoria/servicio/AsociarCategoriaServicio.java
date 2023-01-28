package com.ventacontable.categoria.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.categoria.puerto.dao.DaoCategoria;
import com.ventacontable.producto.puerto.dao.DaoProducto;

import java.util.List;

public class AsociarCategoriaServicio {

    private static final String DEBE_INGRESAR_PRODUCTO_VALIDO = "El producto igresado no existe";
    private static final String CATEGORIA_INVALIDA = "Las categorias seleccionadas no son validas, intente de nuevo";

    private final DaoProducto daoProducto;
    private final DaoCategoria daoCategoria;

    public AsociarCategoriaServicio(DaoProducto daoProducto, DaoCategoria daoCategoria){
        this.daoProducto = daoProducto;
        this.daoCategoria = daoCategoria;
    }


    public void ejecutar(int idProducto, List<Integer> categorias){
        validarPreviaExistenciaProducto(idProducto);
        List<Integer> categoriasValidas = daoCategoria.existeIdCategoriaBatch(categorias);
        validarCategoriasExistentes(categorias,categoriasValidas);
    }

    private void validarCategoriasExistentes(List<Integer> categorias,List<Integer> categoriasExistentes){
        categoriasExistentes.remove(categorias);
        if(categoriasExistentes.size()>0){
            throw new ExcepcionSinDatos(CATEGORIA_INVALIDA);
        }
    }

    private void validarPreviaExistenciaProducto(Integer idProducto){
        if(!daoProducto.existeIdProducto(idProducto)){
            throw new ExcepcionSinDatos(DEBE_INGRESAR_PRODUCTO_VALIDO);
        }
    }
}
