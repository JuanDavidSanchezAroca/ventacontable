package com.ventacontable.configuracion.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventacontable.usuario.modelo.entidad.UserDetailsImpl;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Usuario usuario = new Usuario();
        try {
            usuario = new ObjectMapper().readValue(request.getReader(),Usuario.class);
        }catch ( IOException e){}

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                usuario.getUsuario(),
                usuario.getPassword(),
                Collections.emptyList()
        );
        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
     UserDetailsImpl userDetails = (UserDetailsImpl)authResult.getPrincipal();
     String token = TokenUtil.crateToken(userDetails.getUsername());

     response.addHeader("Authorization", "Bearer "+token);
     response.getWriter().flush();
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
