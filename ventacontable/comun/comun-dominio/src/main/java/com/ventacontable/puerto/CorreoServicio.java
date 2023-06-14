package com.ventacontable.puerto;

import com.ventacontable.dominio.plantillas.PlantillaHtmlCorreo;

import java.util.Map;

/**
 * Interfaz que permite definir las operaciones de envio de correo
 */
public interface CorreoServicio {
    String enviarCorreo(String from, String text, String destino);
    String enviarCorreoHtml(String from, Map<String, Object> valores, String destino, PlantillaHtmlCorreo plantillaHtmlCorreo);
}
