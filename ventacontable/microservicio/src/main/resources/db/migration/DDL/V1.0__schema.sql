CREATE TABLE ROL(
    id_rol serial PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200) NOT NULL
);
CREATE TABLE PERMISO(
    id_permiso serial PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);
CREATE TABLE ROL_X_PERMISO(
    id_rol_x_permiso serial PRIMARY KEY,
    id_rol INT,
    id_permiso INT,
    FOREIGN KEY (id_rol) REFERENCES ROL(id_rol),
    FOREIGN KEY (id_permiso) REFERENCES PERMISO(id_permiso)
);

CREATE TABLE PERSONA(
    id_persona serial PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    identificacion VARCHAR(100) NOT NULL,
    tipo_documento VARCHAR(100) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    direccion VARCHAR(200) NOT NULL
);
CREATE TABLE USUARIO (
     id_usuario serial  PRIMARY KEY,
     id_persona INT,
     id_rol INT,
     correo   VARCHAR(100) NOT NULL,
     password VARCHAR(100) NOT NULL,
     FOREIGN KEY (id_persona) REFERENCES PERSONA(id_persona),
     FOREIGN KEY (id_rol) REFERENCES ROL(id_rol)
);

CREATE TABLE PRODUCTO(
    id_producto serial PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion VARCHAR(1000),
    precio_minimo FLOAT,
    precio_maximo FLOAT,
    precio_base FLOAT NOT NULL,
    talla VARCHAR(50) NOT NULL,
    color VARCHAR(100) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    cantidad_disponible INT
);

CREATE TABLE INVENTARIO(
    id_inventario serial PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL,
    fecha_ingreso TIMESTAMP,
    cantidad INT NOT NULL,
    id_producto INT,
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto)
);

CREATE TABLE VENTA(
    id_venta serial PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    valor_total FLOAT NOT NULL,
    id_vendedor INT NOT NULL,
    id_comprador INT NOT NULL,
    FOREIGN KEY (id_vendedor) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (id_comprador) REFERENCES PERSONA(id_persona)
);

CREATE TABLE SEPARADO(
    id_separado serial PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL,
    id_comprador INT NOT NULL,
    id_vendedor INT NOT NULL,
    fecha_inicial TIMESTAMP NOT NULL,
    fecha_final TIMESTAMP NOT NULL,
    saldo_pendiente FLOAT NOT NULL,
    valor_total FLOAT NOT NULL,
    FOREIGN KEY (id_comprador) REFERENCES PERSONA(id_persona),
    FOREIGN KEY (id_vendedor) REFERENCES USUARIO(id_usuario)
);

CREATE TABLE PRODUCTO_X_VENTA(
    id_producto_x_venta serial PRIMARY KEY,
    id_producto INT,
    id_venta INT,
    id_separado INT,
    cantidad INT NOT NULL,
    precio_unidad FLOAT,
    valor_total FLOAT,
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto),
    FOREIGN KEY (id_venta) REFERENCES VENTA(id_venta),
    FOREIGN KEY (id_separado) REFERENCES SEPARADO(id_separado)
);

CREATE TABLE HISTORIAL_ABONO(
    id_historial_abono serial PRIMARY KEY,
    id_vendedor INT,
    id_comprador INT,
    id_separado INT,
    fecha_abono TIMESTAMP NOT NULL,
    valor FLOAT NOT NULL,
    FOREIGN KEY (id_comprador) REFERENCES PERSONA(id_persona),
    FOREIGN KEY (id_vendedor) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (id_separado) REFERENCES SEPARADO(id_separado)
);

CREATE TABLE CATEGORIA(
    id_categoria serial PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL
);

CREATE TABLE CATEGORIA_X_PRODUCTO(
    id_categoria_x_producto serial PRIMARY KEY,
    id_categoria INT,
    id_producto INT,
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id_categoria),
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto)
);