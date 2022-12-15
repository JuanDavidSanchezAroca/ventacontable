package com.ventacontable.comando.separado;

import com.ventacontable.comun.modelo.Item;
import com.ventacontable.separado.modelo.Abono;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSeparado {

    private String codigo;
    private LocalDateTime fechaInicial;
    private LocalDateTime fechaFinal;
    private double saldoPendiente;
    private double valorTotal;
    private List<Item> items;
    private List<Abono> abonos;
    private Integer vendedor;
    private Integer comprador;


}
