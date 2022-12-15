package com.ventacontable.separado.puerto.repositorio;

import com.ventacontable.separado.modelo.Separado;

public interface RepositorioSeparado {

    /**
     * Permite crear un separado
     *
     * @param separado
     * @return el id generado para el separado
     */
    Integer crear(Separado separado);

}
