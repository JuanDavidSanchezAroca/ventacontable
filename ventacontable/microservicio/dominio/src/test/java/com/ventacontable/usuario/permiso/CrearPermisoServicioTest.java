package com.ventacontable.usuario.permiso;

import com.ventacontable.core.BasePrueba;
import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.dominio.excepcion.ExcepcionValorInvalido;
import com.ventacontable.dominio.excepcion.ExcepcionValorObligatorio;
import com.ventacontable.usuario.builder.PermisoBuilder;
import com.ventacontable.usuario.modelo.entidad.Permiso;
import com.ventacontable.usuario.puerto.dao.DaoPermiso;
import com.ventacontable.usuario.puerto.repositorio.RepositorioPermiso;
import com.ventacontable.usuario.servicio.permiso.CrearPermisoServicio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearPermisoServicioTest {

    private RepositorioPermiso repositorioPermiso;
    private DaoPermiso daoPermiso;
    private CrearPermisoServicio crearPermisoServicio;

    @Before
    public void configuracion() {
        repositorioPermiso = Mockito.mock(RepositorioPermiso.class);
        daoPermiso = Mockito.mock(DaoPermiso.class);
    }

    @Test
    public void validarNombreObligatorio() {
        PermisoBuilder permisoBuilder = new PermisoBuilder().conNombre(null);
        BasePrueba.assertThrows(() -> permisoBuilder.build(),
                ExcepcionValorObligatorio.class, "El nombre es requerido");
    }

    @Test
    public void validarNombreNoVacio() {
        PermisoBuilder permisoBuilder = new PermisoBuilder().conNombre("");
        BasePrueba.assertThrows(() -> permisoBuilder.build(),
                ExcepcionValorInvalido.class, "Debe ingresar un valor en el nombre");
    }

    @Test
    public void registrarPermiso() {
        Permiso permiso = new PermisoBuilder().build();
        Mockito.when(daoPermiso.buscarNombre(Mockito.any())).thenReturn(false);
        Mockito.when(repositorioPermiso.registrar(Mockito.any())).thenReturn(1);
        crearPermisoServicio = new CrearPermisoServicio(repositorioPermiso, daoPermiso);
        int idRespuesta = crearPermisoServicio.ejecutar(permiso);
        Assert.assertEquals(1, idRespuesta);
    }

    @Test
    public void errorPermisoYaExiste() {
        Permiso permiso = new PermisoBuilder().build();
        Mockito.when(daoPermiso.buscarNombre(Mockito.any())).thenReturn(true);
        Mockito.when(repositorioPermiso.registrar(Mockito.any())).thenReturn(1);
        crearPermisoServicio = new CrearPermisoServicio(repositorioPermiso, daoPermiso);
        try {
            crearPermisoServicio.ejecutar(permiso);
        } catch (ExcepcionDuplicidad e) {
            Assert.assertEquals("El permiso ingresado ya existe", e.getMessage());
        }
    }
}
