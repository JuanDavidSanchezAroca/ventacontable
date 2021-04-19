package com.ventacontable.usuario.servicio;

import com.ventacontable.core.BasePrueba;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;
import com.ventacontable.dominio.excepcion.ExcepcionDuplicidad;
import com.ventacontable.dominio.excepcion.ExcepcionLongitudValor;
import com.ventacontable.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;


public class ServicioCrearUsuarioTest {


    @Test
    public void validarClaveLongitudMenor4Test() {
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conPassword("124");
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class,
                "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);

        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);

        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
