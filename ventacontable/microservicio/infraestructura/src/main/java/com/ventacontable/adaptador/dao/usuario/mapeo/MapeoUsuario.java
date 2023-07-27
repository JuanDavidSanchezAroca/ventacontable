package com.ventacontable.adaptador.dao.usuario.mapeo;

import com.ventacontable.infraestructura.jdbc.MapperResult;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuario implements RowMapper<Usuario>, MapperResult {
    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        String correo = rs.getString("correo");
        String password = rs.getString("password");
        return new Usuario(correo,password);
    }
}
