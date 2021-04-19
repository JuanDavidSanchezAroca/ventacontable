package com.ventacontable.usuario.consulta;

import java.util.List;

import com.ventacontable.usuario.puerto.dao.DaoUsuario;
import com.ventacontable.usuario.modelo.dto.DtoUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarUsuarios {

    private final DaoUsuario daoUsuario;

    public ManejadorListarUsuarios(DaoUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }

    public List<DtoUsuario> ejecutar(){ return this.daoUsuario.listar(); }
}
