package com.ventacontable.comando.producto.categoria.manejador;

import com.ventacontable.comando.producto.categoria.ComandoCategoria;
import com.ventacontable.comando.producto.categoria.fabrica.CategoriaFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.producto.modelo.entidad.Categoria;
import com.ventacontable.producto.servicio.categoria.ActualizarCategoriaServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarCategoria {
    private final ActualizarCategoriaServicio actualizarCategoriaServicio;
    private final CategoriaFabrica categoriaFabrica;

    public ManejadorActualizarCategoria(ActualizarCategoriaServicio actualizarCategoriaServicio,
                                        CategoriaFabrica categoriaFabrica){
        this.actualizarCategoriaServicio = actualizarCategoriaServicio;
        this.categoriaFabrica = categoriaFabrica;
    }
    @Transactional
    public Integer ejecutar(ComandoCategoria comandoCategoria, Integer id){
        Categoria categoria = this.categoriaFabrica.ejecutar(comandoCategoria);
        return this.actualizarCategoriaServicio.ejecutar(categoria, id);
    }
}
