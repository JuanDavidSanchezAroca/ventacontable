CREATE TABLE ROL(
    id serial PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200) NOT NULL
);

CREATE TABLE PERMISO(
    id serial PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE ROL_X_PERMISO(
    id serial PRIMARY KEY,
    id_rol INT,
    id_permiso INT,
    FOREIGN KEY (id_rol) REFERENCES ROL(id),
    FOREIGN KEY (id_permiso) REFERENCES PERMISO(id)
);

CREATE TABLE USUARIO (
     id serial  PRIMARY KEY,
     correo   VARCHAR(100) NOT NULL,
     password VARCHAR(100) NOT NULL
);

CREATE TABLE PERSONA(
    id serial PRIMARY KEY,
    identificacion VARCHAR(100) NOT NULL,
    tipo_documento VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    telefono VARCHAR(50) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    id_rol INT,
    id_usuario INT,
    FOREIGN KEY (id_rol) REFERENCES ROL(id),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id)
);

CREATE TABLE PRODUCTO(
    id serial PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    descripcion VARCHAR(1000),
    precio_minimo FLOAT,
    precio_maximo FLOAT,
    precio_base FLOAT NOT NULL,
    talla VARCHAR(50) NOT NULL,
    color VARCHAR(100) NOT NULL,
    cantidad_disponible INT
);

CREATE TABLE INVENTARIO(
    id serial PRIMARY KEY,
    fecha_ingreso TIMESTAMP,
    cantidad INT NOT NULL,
    id_producto INT,
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id)
);

CREATE TABLE VENTA(
    id serial PRIMARY KEY,
    fecha TIMESTAMP NOT NULL,
    valor_total FLOAT NOT NULL,
    id_vendedor INT NOT NULL,
    id_comprador INT NOT NULL,
    FOREIGN KEY (id_vendedor) REFERENCES PERSONA(id),
    FOREIGN KEY (id_comprador) REFERENCES PERSONA(id)
);

CREATE TABLE SEPARADO(
    id serial PRIMARY KEY,
    id_comprador INT NOT NULL,
    id_vendedor INT NOT NULL,
    fecha_inicial TIMESTAMP NOT NULL,
    fecha_final TIMESTAMP NOT NULL,
    saldo_pendiente FLOAT NOT NULL,
    valor_total FLOAT NOT NULL,
    FOREIGN KEY (id_comprador) REFERENCES PERSONA(id),
    FOREIGN KEY (id_vendedor) REFERENCES PERSONA(id)
);

CREATE TABLE ITEM(
    id serial PRIMARY KEY,
    id_producto INT,
    id_venta INT,
    id_separado INT,
    cantidad INT NOT NULL,
    precio_unidad FLOAT,
    valor_total FLOAT,
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id),
    FOREIGN KEY (id_venta) REFERENCES VENTA(id),
    FOREIGN KEY (id_separado) REFERENCES SEPARADO(id)
);

CREATE TABLE ABONO(
    id serial PRIMARY KEY,
    id_receptor INT,
    id_pagador INT,
    id_separado INT,
    fecha_abono TIMESTAMP NOT NULL,
    valor FLOAT NOT NULL,
    FOREIGN KEY (id_receptor) REFERENCES PERSONA(id),
    FOREIGN KEY (id_pagador) REFERENCES PERSONA(id),
    FOREIGN KEY (id_separado) REFERENCES SEPARADO(id)
);

CREATE TABLE CATEGORIA(
    id serial PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL
);

CREATE TABLE CATEGORIA_X_PRODUCTO(
    id serial PRIMARY KEY,
    id_categoria INT,
    id_producto INT,
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id),
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id)
);