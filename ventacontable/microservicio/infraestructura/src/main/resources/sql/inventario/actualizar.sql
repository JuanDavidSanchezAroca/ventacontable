UPDATE inventario SET
    fecha_ingreso=:fechaIngreso,
    cantidad=:cantidad,
    disponible=:disponible,
    id_producto=:idProducto

   WHERE id_inventario=:codigo