SELECT id_inventario,id_producto,fecha_ingreso,cantidad,disponible FROM inventario
WHERE id_producto = :idProducto