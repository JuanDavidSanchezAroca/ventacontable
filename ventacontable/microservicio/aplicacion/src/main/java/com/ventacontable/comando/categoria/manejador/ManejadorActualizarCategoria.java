package com.ventacontable.comando.categoria.manejador;

import com.ventacontable.comando.categoria.ComandoCategoria;
import com.ventacontable.comando.categoria.fabrica.CategoriaFabrica;
import com.ventacontable.categoria.modelo.entidad.Categoria;
import com.ventacontable.categoria.servicio.ActualizarCategoriaServicio;
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
