package com.ventacontable.comando.categoria.manejador;

import com.ventacontable.categoria.modelo.dto.DtoCategoria;
import com.ventacontable.categoria.puerto.dao.DaoCategoria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCategorias {

    private final DaoCategoria daoCategoria;


    public ManejadorListarCategorias(DaoCategoria daoCategoria) {
        this.daoCategoria = daoCategoria;
    }

    public List<DtoCategoria> ejecutar(){
       return daoCategoria.listarCategorias();
    }
}
