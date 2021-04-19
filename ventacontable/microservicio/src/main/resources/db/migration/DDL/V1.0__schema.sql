CREATE TABLE ROL(
    id_rol INT NOT NULL,
    rol VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_rol)
);

CREATE TABLE USUARIO (
     id_usuario serial  PRIMARY KEY,
     nombre_completo  VARCHAR(100) NOT NULL,
     password VARCHAR(100) NOT NULL,
     correo   VARCHAR(100) NOT NULL,
     imagen   VARCHAR(100) NOT NULL
);

CREATE TABLE USUARIO_X_ROL(
    id_usuario_rol serial PRIMARY KEY ,
    id_rol INT NOT NULL,
    id_usuario serial NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (id_rol)  REFERENCES ROL(id_rol)
);

CREATE TABLE PRODUCTO(
    id_producto serial PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    descripcion VARCHAR(1000),
    precio_minimo FLOAT,
    precio_maximo FLOAT,
    precio_base FLOAT
);

CREATE TABLE INVENTARIO(
    id_inventario serial PRIMARY KEY,
    id_producto INT NOT NULL,
    fecha_ingreso TIMESTAMP,
    cantidad INT,
    disponible INT,
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto)
);

CREATE TABLE VENTA(
    id_venta serial PRIMARY KEY,
    id_usuario serial NOT NULL,
    id_comprador VARCHAR(11),
    fecha TIMESTAMP,
    valor_total FLOAT,
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario)
);

CREATE TABLE SEPARADO(
    id_separado serial PRIMARY KEY,
    id_comprador VARCHAR(30),
    fecha_inicial TIMESTAMP,
    fecha_final TIMESTAMP,
    saldo_pendiente FLOAT,
    valor_total FLOAT
);

CREATE TABLE PRODUCTO_X_VENTA(
    id_producto_x_venta serial PRIMARY KEY,
    id_producto INT,
    id_venta INT,
    id_separado INT,
    cantidad INT NOT NULL,
    valor_total FLOAT,
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto),
    FOREIGN KEY (id_venta) REFERENCES VENTA(id_venta),
    FOREIGN KEY (id_separado) REFERENCES SEPARADO(id_separado)
);

CREATE TABLE HISTORIAL_SEPARADO(
    id_historial_separado serial PRIMARY KEY,
    id_usuario serial,
    id_separado INT,
    fecha_abono TIMESTAMP,
    valor FLOAT,
    FOREIGN KEY (id_separado) REFERENCES SEPARADO(id_separado),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario)
);