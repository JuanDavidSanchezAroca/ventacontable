package com.ventacontable.infraestructura.servicios.mail;

import com.ventacontable.dominio.plantillas.PlantillaHtmlCorreo;
import com.ventacontable.puerto.CorreoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@Component
public class ServicioCorreoMail implements CorreoServicio {

    private static final String CORREO_ENVIADO_EXITOSAMENTE = "Correo enviado correctamente";
    private static final String ERROR_ENVIAR_CORREO = "Error al enviar el correo";
    private static final String RUTA_IMAGENES = "templates/imagenes/";
    @Autowired
    public JavaMailSender enviar;
    @Autowired
    public  PlantillaCorreo plantillaCorreo;

    @Override
    public String enviarCorreo(String from, String text, String destino) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(destino);
            message.setSubject(from);
            message.setText(text);
            enviar.send(message);
            return CORREO_ENVIADO_EXITOSAMENTE;
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
        return ERROR_ENVIAR_CORREO;
    }


    @Override
    public String enviarCorreoHtml(String from, Map<String,
            Object> valores, String destino, PlantillaHtmlCorreo plantillaHtmlCorreo) {
        MimeMessage message = enviar.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
            mimeMessageHelper.setTo(destino);
            mimeMessageHelper.setSubject(from);
            mimeMessageHelper.setText(plantillaCorreo.generarCorreoHTML(valores,plantillaHtmlCorreo.getNombre()),true);
            for(String imagen : plantillaHtmlCorreo.getImagen()){
                ClassPathResource file = new ClassPathResource(RUTA_IMAGENES+imagen);
                mimeMessageHelper.addInline(imagen,file);
            }
            enviar.send(message);
            return CORREO_ENVIADO_EXITOSAMENTE;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ERROR_ENVIAR_CORREO;
    }
}
