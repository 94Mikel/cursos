-- USUARIO

-- El email_normalizado nos sirve para tener en mayusculas el email.
-- Es util para realizar comparaciones rapidas entre datos que tengan las mismas mayusculas.

CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    email VARCHAR(256) NOT NULL,
    email_normalizado VARCHAR(256) NOT NULL,
    password_hash VARCHAR NOT NULL
);

-- CUENTAS

CREATE TABLE tipos_cuentas (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuarios(id),
    nombre VARCHAR(50) NOT NULL,
    orden INTEGER NOT NULL
);

CREATE TABLE cuentas (
    id SERIAL PRIMARY KEY,
    tipo_cuenta_id INTEGER NOT NULL REFERENCES tipos_cuentas(id),
    nombre VARCHAR(50) NOT NULL,
    balance DECIMAL(18,2) NOT NULL,
    descripcion VARCHAR(1000)
);

-- OPERACION

CREATE TABLE tipos_operaciones (
    id SERIAL PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
);

-- CATEGORIA

CREATE TABLE categorias (
    id SERIAL PRIMARY KEY,
    tipo_operacion_id INTEGER NOT NULL REFERENCES tipos_operaciones(id),
    usuario_id INTEGER NOT NULL REFERENCES usuarios(id),
    nombre VARCHAR(50)
);

-- TRANSACCIONES

CREATE TABLE transacciones (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuarios(id),
    cuenta_id INTEGER NOT NULL REFERENCES cuentas(id),
    tipo_operacion_id INTEGER NOT NULL REFERENCES tipos_operaciones(id),
    categoria_id INTEGER NOT NULL REFERENCES categorias(id),
    fecha_transaccion date NOT NULL,
    monto decimal(18,2) NOT NULL,
    nota VARCHAR(1000)
);


-- INSERCIÓN

---- USUARIO

INSERT INTO usuarios(email,email_normalizado,password_hash) VALUES('prueba@mail.com','PRUEBA@MAIL.COM','abc');
