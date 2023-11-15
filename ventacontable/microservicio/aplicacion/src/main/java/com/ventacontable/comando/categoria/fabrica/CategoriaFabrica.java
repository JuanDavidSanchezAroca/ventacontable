package com.ventacontable.comando.categoria.fabrica;

import com.ventacontable.comando.categoria.ComandoCategoria;
import com.ventacontable.categoria.modelo.entidad.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaFabrica {
    public Categoria ejecutar(ComandoCategoria comandoCategoria){
        return new Categoria(comandoCategoria.getNombre(),comandoCategoria.getDescripcion());
    }
}