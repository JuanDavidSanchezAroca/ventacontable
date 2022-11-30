package com.ventacontable.usuario.permiso;

import com.ventacontable.core.BasePrueba;
import com.ventacontable.excepcion.ExcepcionNegocio;
import com.ventacontable.usuario.builder.PermisoBuilder;
import com.ventacontable.usuario.modelo.Permiso;
import com.ventacontable.usuario.puerto.dao.DaoPermiso;
import com.ventacontable.usuario.puerto.repositorio.RepositorioPermiso;
import com.ventacontable.usuario.servicio.CrearPermisoServicio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearPermisoServicioTest {

    private RepositorioPermiso repositorioPermiso;
    private DaoPermiso daoPermiso;
    private CrearPermisoServicio crearPermisoServicio;

    @Before
    public void configuracion(){
        repositorioPermiso = Mockito.mock(RepositorioPermiso.class);
        daoPermiso = Mockito.mock(DaoPermiso.class);
    }

    @Test
    public void registrarPermiso(){
        //Arrange
        Permiso permiso = new PermisoBuilder().build();
        Mockito.when(daoPermiso.buscar(Mockito.any())).thenReturn(false);
        Mockito.when(repositorioPermiso.registrar(Mockito.any())).thenReturn(1);
        crearPermisoServicio = new CrearPermisoServicio(repositorioPermiso,daoPermiso);
        //Act
        int idRespuesta = crearPermisoServicio.ejecutar(permiso);
        //Assert
        Assert.assertEquals(1,idRespuesta);
    }

    @Test
    public void errorPermisoYaExiste(){
        //Arrange
        Permiso permiso = new PermisoBuilder().build();
        Mockito.when(daoPermiso.buscar(Mockito.any())).thenReturn(true);
        Mockito.when(repositorioPermiso.registrar(Mockito.any())).thenReturn(1);
        crearPermisoServicio = new CrearPermisoServicio(repositorioPermiso,daoPermiso);
        //Act
        try {
            crearPermisoServicio.ejecutar(permiso);
        }catch (ExcepcionNegocio e){
            //Assert
            Assert.assertEquals("El permiso ingresado ya existe",e.getMessage());
        }
    }
}
