package com.ventacontable.producto.categoria;

import com.ventacontable.categoria.modelo.Categoria;
import com.ventacontable.categoria.puerto.dao.DaoCategoria;
import com.ventacontable.categoria.puerto.repositorio.RepositorioCategoria;
import com.ventacontable.categoria.servicio.CrearCategoriaServicio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ventacontable.producto.builder.CategoriaBuilder;
//import com.ventacontable.usuario.puerto.dao.DaoCategoria;


public class CrearCategoriaServicioTest {

    private RepositorioCategoria repositorioCategoria;
    private DaoCategoria daoCategoria;
    private CrearCategoriaServicio crearCategoriaServicio;

    @Before
    public void configuracion() {
        repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
        daoCategoria = Mockito.mock(DaoCategoria.class);
    }

    @Test
    public void registrarCategoria() {
        //Arrange
        Categoria categoria = new CategoriaBuilder().build();
        //Mockito.when(daoPermiso.buscar(Mockito.any())).thenReturn(false);
        Mockito.when(repositorioCategoria.crear(Mockito.any())).thenReturn(1);
        crearCategoriaServicio = new CrearCategoriaServicio(repositorioCategoria,daoCategoria);
        //Act
        int idRespuesta = crearCategoriaServicio.ejecutar(categoria);
        //Assert
        Assert.assertEquals(1, idRespuesta);
    }

}


