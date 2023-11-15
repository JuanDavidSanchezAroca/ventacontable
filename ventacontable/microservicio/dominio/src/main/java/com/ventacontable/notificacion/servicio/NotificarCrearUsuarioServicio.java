package com.ventacontable.notificacion.servicio;

import com.ventacontable.dominio.plantillas.PlantillaHtmlCorreo;
import com.ventacontable.puerto.CorreoServicio;
import com.ventacontable.usuario.modelo.entidad.Usuario;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@EnableAsync
public class NotificarCrearUsuarioServicio {
    private static final String PASSWORD = "password";
    private static final String ENCABEZADO_CREACION = "Se acaba de generar tu usuario para ventacontable";

    private final CorreoServicio correoServicio;

    public NotificarCrearUsuarioServicio(CorreoServicio correoServicio) {
        this.correoServicio = correoServicio;
    }

    @Async
    public void ejecutar(Usuario usuario){
        Map<String, Object> valores = new HashMap<>();
        valores.put(PASSWORD,usuario.getPassword());

       String respuest =  correoServicio.enviarCorreoHtml(ENCABEZADO_CREACION,valores, usuario.getUsuario()
                , PlantillaHtmlCorreo.CREACION_NUEVO_USUARIO);

       if(respuest.equals("Error al enviar el correo")){
           throw new RuntimeException("error enviando el correo");
       }
    }
}
