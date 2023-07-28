package com.ventacontable.adaptador.repositorio.usuario;

import com.ventacontable.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ventacontable.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import com.ventacontable.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioAdaptador implements RepositorioUsuario {
    @SqlStatement(namespace = "usuario", value = "crear")
    private static String sqlRegistrar;
    @SqlStatement(namespace = "usuario", value = "actualizar")
    private static String sqlActualizar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioUsuarioAdaptador(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Integer registrar(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario us = new Usuario(usuario.getUsuario(), encoder.encode(usuario.getPassword()));
        return this.customNamedParameterJdbcTemplate.crear(us, sqlRegistrar, "id").intValue();
    }

    @Override
    public Integer actualizar(Usuario usuario, Integer id) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizar, id);
        return id;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
