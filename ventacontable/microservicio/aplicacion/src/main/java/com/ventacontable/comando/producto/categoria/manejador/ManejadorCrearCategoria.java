package com.ventacontable.comando.producto.categoria.manejador;

import com.ventacontable.comando.producto.categoria.ComandoCategoria;
import com.ventacontable.comando.producto.categoria.fabrica.CategoriaFabrica;
import com.ventacontable.manejador.ManejadorComandoRespuesta;
import com.ventacontable.producto.modelo.entidad.Categoria;
import com.ventacontable.producto.servicio.categoria.CrearCategoriaServicio;
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
