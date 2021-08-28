package com.ventacontable.inventario.servicio;

import com.ventacontable.dominio.excepcion.ExcepcionSinDatos;
import com.ventacontable.dominio.excepcion.ExcepcionValorInvalido;
import com.ventacontable.inventario.modelo.dto.DtoInventario;
import com.ventacontable.inventario.modelo.entidad.Inventario;
import com.ventacontable.inventario.puerto.dao.DaoInventario;
import com.ventacontable.inventario.puerto.repositorio.RepositorioInventario;
import com.ventacontable.producto.puerto.dao.DaoProducto;

public class ServicioActualizarInventario {

    private static final String NO_EXISTE_PRODUCTO="El producto ingresado no se le puede asociar inventario no existe";
    private static final String NO_EXISTE_INVENTARIO="El registro de inventario no existe";
    private static final String CANTIDAD_INCONSISTENTE="La cantidad es inconsistente";

    private final DaoProducto daoProducto;
    private final DaoInventario daoInventario;
    private final RepositorioInventario repositorioInventario;

    public ServicioActualizarInventario(DaoProducto daoProducto,
                                        RepositorioInventario repositorioInventario,
                                        DaoInventario daoInventario) {
        this.daoProducto = daoProducto;
        this.repositorioInventario = repositorioInventario;
        this.daoInventario= daoInventario;
    }

    public long ejecutar(Inventario inventario){
        validarExistenciaPreviaInventario(inventario.getCodigo());
        validarExistenciaPreviaProducto(inventario.getIdProducto());
        validarRegsitroInventario(inventario);
        this.repositorioInventario.actualizar(inventario);
        return inventario.getCodigo();
    }

    private void validarExistenciaPreviaProducto(int idProducto){
        if(!daoProducto.existeIdProducto(idProducto)){
            throw new ExcepcionSinDatos(NO_EXISTE_PRODUCTO);
        }
    }

    private void validarExistenciaPreviaInventario(int idInventario){
        if(!daoInventario.existe(idInventario)){
            throw new ExcepcionSinDatos(NO_EXISTE_INVENTARIO);
        }
    }

    private void validarRegsitroInventario(Inventario inventario){
        DtoInventario dtoInventario = this.daoInventario.obtener(inventario.getCodigo());
        if(inventario.getCantidad() < dtoInventario.getDisponible()){
            throw new ExcepcionValorInvalido(CANTIDAD_INCONSISTENTE);
        }
    }
}
