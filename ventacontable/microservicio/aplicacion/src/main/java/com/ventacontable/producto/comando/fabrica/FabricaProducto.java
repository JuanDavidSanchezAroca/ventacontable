package com.ventacontable.producto.comando.fabrica;

import com.ventacontable.producto.comando.ComandoProducto;
import com.ventacontable.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto){
        return new Producto(
                comandoProducto.getIdProducto(),
                comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getPrecioMinimo(),
                comandoProducto.getPrecioMaximo(),
                comandoProducto.getPrecioBase()
        );
    }
}
