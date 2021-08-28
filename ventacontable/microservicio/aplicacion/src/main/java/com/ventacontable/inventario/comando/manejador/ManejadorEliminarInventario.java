package com.ventacontable.inventario.comando.manejador;

import com.ventacontable.ComandoRespuesta;
import com.ventacontable.inventario.puerto.repositorio.RepositorioInventario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarInventario {

    private final RepositorioInventario repositorioInventario;

    public ManejadorEliminarInventario(RepositorioInventario repositorioInventario) {
        this.repositorioInventario = repositorioInventario;
    }

    public ComandoRespuesta<Long> ejecutar(Integer idInventario){
        this.repositorioInventario.eliminar(idInventario);
        return new ComandoRespuesta<Long>(idInventario*1l);
    }

}
