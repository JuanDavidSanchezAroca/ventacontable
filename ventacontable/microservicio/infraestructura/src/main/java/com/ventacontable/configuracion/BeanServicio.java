package com.ventacontable.configuracion;

import com.ventacontable.inventario.puerto.dao.DaoInventario;
import com.ventacontable.inventario.puerto.repositorio.RepositorioInventario;
import com.ventacontable.inventario.servicio.ServicioActualizarInventario;
import com.ventacontable.inventario.servicio.ServicioCrearInventario;
import com.ventacontable.producto.puerto.dao.DaoProducto;
import com.ventacontable.producto.puerto.repositorio.RepositorioProducto;
import com.ventacontable.producto.servicio.ServicioActualizarProducto;
import com.ventacontable.producto.servicio.ServicioCrearProducto;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;
import com.ventacontable.usuario.servicio.ServicioActualizarUsuario;
import com.ventacontable.usuario.servicio.ServicioCrearUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario){
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto){
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto, DaoProducto daoProducto){
        return new ServicioActualizarProducto(daoProducto,repositorioProducto);
    }

    @Bean
    public ServicioCrearInventario servicioCrearInventario(RepositorioInventario repositorioInventario,DaoProducto daoProducto){
        return  new ServicioCrearInventario(repositorioInventario,daoProducto);
    }

    @Bean
    public ServicioActualizarInventario servicioActualizarInventario(RepositorioInventario repositorioInventario, DaoProducto daoProducto, DaoInventario daoInventario){
        return new ServicioActualizarInventario(daoProducto,repositorioInventario,daoInventario);
    }
}
