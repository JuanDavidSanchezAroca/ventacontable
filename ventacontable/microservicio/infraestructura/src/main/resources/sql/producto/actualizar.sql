UPDATE producto SET
    nombre=:nombre,
    descripcion=:descripcion,
    precio_minimo=:precioMinimo,
    precio_maximo=:precioMaximo,
    precio_base=:precioBase

   WHERE id_producto=:idProducto
