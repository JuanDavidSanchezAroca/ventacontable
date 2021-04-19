update usuario
set nombre_completo = :nombreCompleto,
	password = :password,
	correo = :correo,
	imagen = :imagen
where id_usuario = :idUsuario