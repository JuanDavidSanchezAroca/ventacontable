package com.ventacontable.usuario.puerto.dao;

import com.ventacontable.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoUsuario> listar();
}
