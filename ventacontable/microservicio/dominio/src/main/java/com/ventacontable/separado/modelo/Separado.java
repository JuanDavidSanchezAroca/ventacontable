package com.ventacontable.separado.modelo;

import com.ventacontable.comun.modelo.Item;
import com.ventacontable.persona.modelo.entidad.Persona;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Separado {
    private String codigo;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private double saldoPendiente;
    private double valorTotal;
    private List<Item> items;
    private List<Abono> abonos;
    private Persona vendedor;
    private Persona comprador;
}
