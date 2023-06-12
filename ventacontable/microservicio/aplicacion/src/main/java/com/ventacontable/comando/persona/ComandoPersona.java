package com.ventacontable.comando.persona;

import com.ventacontable.comando.usuario.usuario.ComandoUsuario;
import com.ventacontable.persona.modelo.entidad.Genero;
import com.ventacontable.persona.modelo.entidad.TipoDocumento;
import com.ventacontable.usuario.modelo.Rol;
import com.ventacontable.usuario.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPersona {

    private String identificacion;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String tipoDocumento;
    private String telefono;
    private String genero;
    private String direccion;
    private ComandoUsuario usuario;
    private Integer rol;
}
