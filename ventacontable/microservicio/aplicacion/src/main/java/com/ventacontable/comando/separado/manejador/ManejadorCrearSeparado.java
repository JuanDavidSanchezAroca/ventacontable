package com.ventacontable.comando.separado.manejador;

import com.ventacontable.comando.separado.ComandoSeparado;
import com.ventacontable.comando.separado.fabrica.SeparadoFabrica;
import com.ventacontable.comando.usuario.permiso.fabrica.PermisoFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.separado.modelo.Separado;
import com.ventacontable.separado.servicio.CrearSeparadoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSeparado implements ManejadorComandoRespuesta<ComandoSeparado, Integer> {

    private final CrearSeparadoServicio crearSeparadoServicio;
    private final SeparadoFabrica separadoFabrica;

    public ManejadorCrearSeparado(CrearSeparadoServicio crearSeparadoServicio, SeparadoFabrica separadoFabrica) {
        this.crearSeparadoServicio = crearSeparadoServicio;
        this.separadoFabrica = separadoFabrica;
    }

    @Override
    public Integer ejecutar(ComandoSeparado comandoSeparado) {
        Separado separado = this.separadoFabrica.ejecutar(comandoSeparado);
        return this.crearSeparadoServicio.Ejecutar(separado);
    }
}
