package com.ventacontable.producto.modelo.entidad;
import lombok.Getter;
import java.util.List;
import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;
import static com.ventacontable.dominio.ValidadorArgumento.validarPositivo;
import static com.ventacontable.dominio.ValidadorArgumento.validarMenor;
import static com.ventacontable.dominio.ValidadorArgumento.validarNoVacio;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_NOMBRE_PRODUCTO = "Se debe ingresar el nombre del producto";
    private static final String SE_DEBE_INGRESAR_CODIGO_PRODUCTO = "Se debe ingresar el codigo del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_MINIMO = "Se debe ingresar el valor minimo del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_MAXIMO = "Se debe ingresar el valor maximo del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_BASE = "Se debe ingresar el valor base del producto";
    private static final String SE_DEBE_INGRESAR_VALORES_POSITIVOS= "Se deben ingresar valores positivos";
    private static final String SE_DEBE_INGRESAR_UN_VALOR_MENOR_AL_MAXIMO =
            "El valor minimo debe ser menor al valor maximo";
    private static final String SE_DEBE_INGRESAR_BASE_MENOR_PRECIO_MINIMO
            = "El valor de la base debe ser menor al precio mínimo";
    private static final String SE_DEBE_INGRESAR_VALOR_POSITIVO = "El valor de cantidad disponible no es permitido";
    private static final String SE_DEBE_INGRESAR_CATEGORIA = "El producto debe tener asociada al menos una categoria";

    private int idProducto;
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioMinimo;
    private double precioMaximo;
    private double precioBase;
    private String talla;
    private String color;
    private int cantidadDisponible;
    private List<Integer> categorias;


    public Producto(int idProducto,String codigo, String nombre, String descripcion,
                    double precioMinimo, double precioMaximo, double precioBase,String talla,
                    String color, Integer cantidadDisponible,List<Integer> categorias) {
        validarObligatorio(nombre,SE_DEBE_INGRESAR_NOMBRE_PRODUCTO);
        validarObligatorio(codigo,SE_DEBE_INGRESAR_CODIGO_PRODUCTO);
        validarObligatorio(precioMinimo,SE_DEBE_INGRESAR_EL_VALOR_MINIMO);
        validarObligatorio(precioMaximo,SE_DEBE_INGRESAR_EL_VALOR_MAXIMO);
        validarObligatorio(precioBase,SE_DEBE_INGRESAR_EL_VALOR_BASE);
        validarPositivo(precioMinimo,SE_DEBE_INGRESAR_VALORES_POSITIVOS);
        validarPositivo(precioMaximo,SE_DEBE_INGRESAR_VALORES_POSITIVOS);
        validarPositivo(precioBase,SE_DEBE_INGRESAR_VALORES_POSITIVOS);
        validarPositivo(cantidadDisponible,SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarMenor(precioMinimo,precioMaximo,SE_DEBE_INGRESAR_UN_VALOR_MENOR_AL_MAXIMO);
        validarMenor(precioBase,precioMinimo,SE_DEBE_INGRESAR_BASE_MENOR_PRECIO_MINIMO);
        validarNoVacio(categorias,SE_DEBE_INGRESAR_CATEGORIA);
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
        this.precioBase = precioBase;
        this.talla = talla;
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;
        this.categorias = categorias;
    }
}
