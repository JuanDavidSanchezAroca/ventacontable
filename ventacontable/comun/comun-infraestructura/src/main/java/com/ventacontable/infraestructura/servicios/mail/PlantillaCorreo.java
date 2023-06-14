package com.ventacontable.infraestructura.servicios.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;
import java.util.Map;

@Component
public class PlantillaCorreo {

    @Autowired
    private TemplateEngine templateEngine;

    public String generarCorreoHTML(Map<String,Object> variables, String nombrePlantilla){
        return this.templateEngine.process(nombrePlantilla, new Context(Locale.getDefault(),variables));
    }
}
