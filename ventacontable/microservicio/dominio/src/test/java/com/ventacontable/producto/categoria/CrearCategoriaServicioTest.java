package com.ventacontable.producto.categoria;

import com.ventacontable.producto.modelo.entidad.Categoria;
import com.ventacontable.producto.puerto.repositorio.RepositorioCategoria;
import com.ventacontable.producto.servicio.ServicioCrearCategoria;
import com.ventacontable.usuario.modelo.Permiso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ventacontable.core.BasePrueba;
import com.ventacontable.excepcion.ExcepcionNegocio;
import com.ventacontable.producto.builder.CategoriaBuilder;
import com.ventacontable.usuario.modelo.Permiso;
//import com.ventacontable.usuario.puerto.dao.DaoCategoria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearCategoriaServicioTest {

    private RepositorioCategoria repositorioCategoria;
    private ServicioCrearCategoria servicioCrearCategoria;

    @Before
    public void configuracion(){
        repositorioCategoria = Mockito.mock(RepositorioCategoria.class);
        //daoPermiso = Mockito.mock(DaoPermiso.class);
    }

    @Test
    public void registrarCategoria(){
        //Arrange
        Categoria categoria = new CategoriaBuilder().build();
        //Mockito.when(daoPermiso.buscar(Mockito.any())).thenReturn(false);
        Mockito.when(repositorioCategoria.crear(Mockito.any())).thenReturn(1);
        servicioCrearCategoria = new ServicioCrearCategoria(repositorioCategoria);
        //Act
        int idRespuesta = servicioCrearCategoria.ejecutar(categoria);
        //Assert
        Assert.assertEquals(1,idRespuesta);
    }

//    @Test
//    public void errorPermisoYaExiste(){
//        //Arrange
//        Permiso permiso = new PermisoBuilder().build();
//        Mockito.when(daoPermiso.buscar(Mockito.any())).thenReturn(true);
//        Mockito.when(repositorioPermiso.registrar(Mockito.any())).thenReturn(1);
//        crearPermisoServicio = new CrearPermisoServicio(repositorioPermiso,daoPermiso);
//        //Act
//        try {
//            crearPermisoServicio.ejecutar(permiso);
//        }catch (ExcepcionNegocio e){
//            //Assert
//            Assert.assertEquals("El permiso ingresado ya existe",e.getMessage());
//        }
//    }
}


