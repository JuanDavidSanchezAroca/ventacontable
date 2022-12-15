package com.ventacontable.comando.separado.fabrica;

import com.ventacontable.comando.separado.ComandoSeparado;
import com.ventacontable.separado.modelo.Separado;
import org.springframework.stereotype.Component;

@Component
public class SeparadoFabrica {
    public Separado ejecutar(ComandoSeparado comandoSeparado){
        return new Separado(comandoSeparado.getCodigo(), comandoSeparado.getFechaInicial(),comandoSeparado.getFechaFinal(),comandoSeparado.getSaldoPendiente(),comandoSeparado.getValorTotal(),
                comandoSeparado.getItems(), comandoSeparado.getAbonos(),comandoSeparado.getVendedor(), comandoSeparado.getComprador());
    }
}
