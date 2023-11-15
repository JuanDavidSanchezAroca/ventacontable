package com.ventacontable.comando.usuario.rol.manejador;

import com.ventacontable.usuario.modelo.dto.DtoRol;
import com.ventacontable.usuario.puerto.dao.DaoRol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarRol {
    private final DaoRol daoRol;
    public ManejadorListarRol(DaoRol daoRol) {
        this.daoRol = daoRol;
    }

    public List<DtoRol> ejecutar(){
        return this.daoRol.listar();
    }
}
