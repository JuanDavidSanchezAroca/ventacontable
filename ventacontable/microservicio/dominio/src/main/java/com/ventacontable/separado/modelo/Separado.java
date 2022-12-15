package com.ventacontable.separado.modelo;

import com.ventacontable.comun.modelo.Item;
import com.ventacontable.usuario.modelo.Persona;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

import static com.ventacontable.dominio.ValidadorArgumento.validarNoVacio;
import static com.ventacontable.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Separado {

    private static final String SE_DEBE_INGRESAR_CODIGO = "Se debe ingresar el codigo";
    private static final String SE_DEBE_INGRESAR_FECHA_INICIAL = "Se debe ingresar la fecha inicial";
    private static final String SE_DEBE_INGRESAR_FECHA_FINAL = "Se debe ingresar la fecha final";
    private static final String SE_DEBE_INGRESAR_SALDO_PENDIENTE = "Se debe ingresar el saldo pendiente";
    private static final String SE_DEBE_INGRESAR_VALOR_TOTAL = "Se debe ingresar el valor total";
    private static final String SE_DEBE_INGRESAR_EL_ID_VENDEDOR = "Se debe ingresar el id del vededor";
    private static final String SE_DEBE_INGRESAR_EL_ID_COMPRADOR = "Se debe ingresar el id del comprador";
    private String codigo;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private double saldoPendiente;
    private double valorTotal;
    private List<Item> items;
    private List<Abono> abonos;
    private Integer vendedor;
    private Integer comprador;

   public Separado (String codigo,LocalDateTime fechaInicial, LocalDateTime fechaFinal, double saldoPendiente, double valorTotal, List<Item> items,
   List<Abono> abonos, Integer vendedor, Integer comprador){
       validarObligatorio(codigo,SE_DEBE_INGRESAR_CODIGO);
       validarObligatorio(fechaInicial,SE_DEBE_INGRESAR_FECHA_INICIAL);
       validarObligatorio(fechaFinal,SE_DEBE_INGRESAR_FECHA_FINAL);
       validarObligatorio(saldoPendiente,SE_DEBE_INGRESAR_SALDO_PENDIENTE);
       validarObligatorio(valorTotal,SE_DEBE_INGRESAR_VALOR_TOTAL);
       validarObligatorio(vendedor,SE_DEBE_INGRESAR_EL_ID_VENDEDOR);
       validarObligatorio(comprador,SE_DEBE_INGRESAR_EL_ID_COMPRADOR);
       this.codigo = codigo;
       this.fechaInicial = fechaInicial;
       this.fechaFinal = fechaFinal;
       this.saldoPendiente = saldoPendiente;
       this.valorTotal = valorTotal;
       this.items = items;
       this.abonos = abonos;
       this.vendedor = vendedor;
       this.comprador = comprador;

   }
}
