package com.ventacontable.dominio.plantillas;


public enum PlantillaHtmlCorreo {

    CREACION_NUEVO_USUARIO("creacion-usuario", new String[]{});
    private String nombre;
    private String[] imagen;

    private PlantillaHtmlCorreo(String nombre,String[] imagen){
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getImagen() {
        return imagen;
    }
}
