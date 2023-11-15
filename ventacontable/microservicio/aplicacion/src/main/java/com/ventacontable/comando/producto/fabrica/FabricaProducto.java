package com.ventacontable.comando.producto.fabrica;

import com.ventacontable.comando.producto.ComandoProducto;
import com.ventacontable.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto){
        return new Producto(
                comandoProducto.getIdProducto(),
                comandoProducto.getCodigo(),
                comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getPrecioMinimo(),
                comandoProducto.getPrecioMaximo(),
                comandoProducto.getPrecioBase(),
                comandoProducto.getTalla(),
                comandoProducto.getColor(),
                comandoProducto.getCantidadDisponible(),
                comandoProducto.getCategorias()
        );
    }
}
