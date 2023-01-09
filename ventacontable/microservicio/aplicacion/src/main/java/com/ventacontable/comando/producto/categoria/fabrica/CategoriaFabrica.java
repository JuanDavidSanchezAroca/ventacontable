package com.ventacontable.comando.producto.categoria.fabrica;

import com.ventacontable.comando.producto.categoria.ComandoCategoria;
import com.ventacontable.producto.modelo.entidad.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaFabrica {
    public Categoria ejecutar(ComandoCategoria comandoCategoria){
        return new Categoria(comandoCategoria.getNombre(),comandoCategoria.getDescripcion());
    }
}
