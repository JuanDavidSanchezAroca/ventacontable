package com.ventacontable.comando.categoria.manejador;

import com.ventacontable.comando.categoria.ComandoCategoria;
import com.ventacontable.comando.categoria.fabrica.CategoriaFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.categoria.modelo.Categoria;
import com.ventacontable.categoria.servicio.CrearCategoriaServicio;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearCategoria implements ManejadorComandoRespuesta<ComandoCategoria, Integer> {
    private final CrearCategoriaServicio crearCategoriaServicio;
    private final CategoriaFabrica categoriaFabrica;


    public ManejadorCrearCategoria(CrearCategoriaServicio crearCategoriaServicio, CategoriaFabrica categoriaFabrica) {
        this.crearCategoriaServicio = crearCategoriaServicio;
        this.categoriaFabrica = categoriaFabrica;
    }

    @Override
    public Integer ejecutar(ComandoCategoria comandoCategoria) {
        Categoria categoria = this.categoriaFabrica.ejecutar(comandoCategoria);
        return this.crearCategoriaServicio.ejecutar(categoria);
    }
}
