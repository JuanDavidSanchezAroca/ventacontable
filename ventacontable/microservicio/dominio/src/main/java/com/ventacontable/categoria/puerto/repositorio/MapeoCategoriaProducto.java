package com.ventacontable.categoria.puerto.repositorio;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class MapeoCategoriaProducto {

    public static Map<String, Object>[]  llenarValores(Integer idProducto, List<Integer> categorias){
        return categorias.stream().map(categoria -> {
            Map<String, Object> mapa  = new HashMap<>();
            mapa.put("idProducto",idProducto);
            mapa.put("idCategoria",categoria);
            return mapa;
        }).collect(Collectors.toList()).toArray(new Map[categorias.size()]);
    }
}
