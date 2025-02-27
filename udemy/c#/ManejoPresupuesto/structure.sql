-- USUARIO

-- El email_normalizado nos sirve para tener en mayusculas el email.
-- Es util para realizar comparaciones rapidas entre datos que tengan las mismas mayusculas.

CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    email VARCHAR(256) NOT NULL,
    email_normalizado VARCHAR(256) NOT NULL,
    password_hash VARCHAR NOT NULL
);

-- CUENTAS

CREATE TABLE tipo_cuenta (
    id_tipo_cuenta SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL REFERENCES usuario(id_usuario),
    nombre VARCHAR(50) NOT NULL,
    orden INTEGER NOT NULL
);

CREATE TABLE cuenta (
    id_cuenta SERIAL PRIMARY KEY,
    id_tipo_cuenta INTEGER NOT NULL REFERENCES tipo_cuenta(id_tipo_cuenta),
    nombre VARCHAR(50) NOT NULL,
    balance DECIMAL(18,2) NOT NULL,
    descripcion VARCHAR(1000)
);

-- OPERACION

CREATE TABLE tipo_operacion (
    id_tipo_operacion SERIAL PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
);

-- CATEGORIA

CREATE TABLE categoria (
    id_categoria SERIAL PRIMARY KEY,
    id_tipo_operacion INTEGER NOT NULL REFERENCES tipo_operacion(id_tipo_operacion),
    id_usuario INTEGER NOT NULL REFERENCES usuario(id_usuario),
    nombre VARCHAR(50)
);

-- TRANSACCIONES

CREATE TABLE transaccion (
    id_transaccion SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL REFERENCES usuario(id_usuario),
    id_cuenta INTEGER NOT NULL REFERENCES cuenta(id_cuenta),
    id_tipo_operacion INTEGER NOT NULL REFERENCES tipo_operacion(id_tipo_operacion),
    id_categoria INTEGER NOT NULL REFERENCES categoria(id_categoria),
    fecha_transaccion date NOT NULL,
    monto decimal(18,2) NOT NULL,
    nota VARCHAR(1000)
);


-- INSERCIÓN

---- USUARIO

INSERT INTO usuario(email,email_normalizado,password_hash) VALUES('prueba@mail.com','PRUEBA@MAIL.COM','abc');
