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


-- PROCEDIMIENTO ALMACENADO tipos_cuentas_insertar
-- Necesitamos obtener el orden mas grande para sumarle 1 al insertar un tipos_cuentas.

CREATE OR REPLACE FUNCTION tipos_cuentas_insertar(
        -- Parametros de entrada del procedimietno almacenado
        v_nombre VARCHAR(50),
        v_usuario_id INT
) RETURNS INTEGER AS $$
DECLARE 
    v_orden int; --Variable interna
    v_id int;
BEGIN
    -- COALESCE => si el valor es distinto de nulo se usa.
    -- Si no, utiliza 0. Para casos que no hay registros.
    SELECT COALESCE(MAX(orden), 0)+1 INTO v_orden
    FROM tipos_cuentas
    WHERE usuario_id = v_usuario_id;

    INSERT INTO tipos_cuentas(nombre,usuario_id,orden)
    VALUES(v_nombre, v_usuario_id, v_orden) RETURNING id INTO v_id;

    RETURN v_id;

END;
$$ LANGUAGE plpgsql;
