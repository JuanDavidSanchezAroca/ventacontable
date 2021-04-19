package com.ventacontable.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ventacontable.infraestructura.jdbc.MapperResult;
import com.ventacontable.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        int  idUsuario = resultSet.getInt("id_usuario");
        String nombreCompleto = resultSet.getString("nombre_completo");
        String password = resultSet.getString("password");
        String correo = resultSet.getString("correo");
        String imagen = resultSet.getString("imagen");

        return new DtoUsuario(idUsuario,nombreCompleto,password,correo,imagen);
    }

}
