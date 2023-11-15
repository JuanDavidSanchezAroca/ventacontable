package com.ventacontable.categoria.puerto.repositorio;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class MapeoCategoriaProducto {

    public static Map<String, Integer>[] llenarValores(Integer idProducto, List<Integer> categorias) {
        return categorias.stream()
                .map(categoria -> Map.of("idProducto", idProducto, "idCategoria", categoria))
                .toArray(Map[]::new);
    }
}
