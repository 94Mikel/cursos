-- BASE DE DATOS PSQL --

-- USUARIO

-- El email_normalizado nos sirve para tener en mayusculas el email.
-- Es util para realizar comparaciones rapidas entre datos que tengan las mismas mayusculas.

CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    email VARCHAR(256) NOT NULL,
    email_normalizado VARCHAR(256) NOT NULL,
    password_hash VARCHAR NOT NULL
);

-- CUENTAS

CREATE TABLE tipos_cuentas (
    tipo_cuenta_id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuarios(usuario_id) ON DELETE CASCADE,
    nombre VARCHAR(50) NOT NULL,
    orden INTEGER NOT NULL
);

CREATE TABLE cuentas (
    cuenta_id SERIAL PRIMARY KEY,
    tipo_cuenta_id INTEGER NOT NULL REFERENCES tipos_cuentas(tipo_cuenta_id) ON DELETE CASCADE,
    nombre VARCHAR(50) NOT NULL,
    balance DECIMAL(18,2) NOT NULL,
    descripcion VARCHAR(1000)
);

-- OPERACION

CREATE TABLE tipos_operaciones (
    tipo_operacion_id SERIAL PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
);

-- CATEGORIA

CREATE TABLE categorias (
    categoria_id SERIAL PRIMARY KEY,
    tipo_operacion_id INTEGER NOT NULL REFERENCES tipos_operaciones(tipo_operacion_id) ON DELETE CASCADE,
    usuario_id INTEGER NOT NULL REFERENCES usuarios(usuario_id) ON DELETE CASCADE,
    nombre VARCHAR(50)
);

-- TRANSACCIONES

CREATE TABLE transacciones (
    transacion_id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuarios(usuario_id) ON DELETE CASCADE,
    cuenta_id INTEGER NOT NULL REFERENCES cuentas(cuenta_id) ON DELETE CASCADE,
    categoria_id INTEGER NOT NULL REFERENCES categorias(categoria_id) ON DELETE CASCADE,
    fecha_transaccion DATETIME NOT NULL,
    monto decimal(18,2) NOT NULL,
    nota VARCHAR(1000)
);


-- INSERCIÓN

---- USUARIO

INSERT INTO usuarios(email,email_normalizado,password_hash) VALUES('prueba@mail.com','PRUEBA@MAIL.COM','abc');

---- TIPOS OPERACIONES

INSERT INTO tipos_operaciones(descripcion) VALUES('Ingresos');
INSERT INTO tipos_operaciones(descripcion) VALUES('Gastos');


-- PROCEDIMIENTOS ALMACENADOS 

-- tipos_cuentas_insertar

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
    VALUES(v_nombre, v_usuario_id, v_orden) RETURNING tipo_cuenta_id INTO v_id;

    RETURN v_id;

END;
$$ LANGUAGE plpgsql;


-- transacciones_insertar --

CREATE OR REPLACE FUNCTION transacciones_insertar(
        -- Parametros de entrada del procedimietno almacenado
        v_usuario_id INT,
        v_fecha_transaccion TIMESTAMP,
        v_monto DECIMAL(18,2),
        v_categoria_id INT,
        v_cuenta_id INT,
        v_nota VARCHAR(1000)
) RETURNS INTEGER AS $$
DECLARE 
    v_id int;
BEGIN

    INSERT INTO transacciones(usuario_id, fecha_transaccion, monto, categoria_id, cuenta_id, nota)
    VALUES(v_usuario_id, v_fecha_transaccion, ABS(v_monto), v_categoria_id, v_cuenta_id, v_nota)
    RETURNING transaccion_id INTO v_id;

    UPDATE cuentas SET balance = balance + v_monto WHERE cuenta_id = v_cuenta_id;

    RETURN v_id;

END;
$$ LANGUAGE plpgsql;

-- transacciones_actualizar --
CREATE OR REPLACE PROCEDURE transacciones_actualizar(
        -- Parametros de entrada del procedimietno almacenado
        v_transaccion_id INT,
        v_fecha_transaccion TIMESTAMP,
        v_monto DECIMAL(18,2),
        v_monto_anterior DECIMAL(18,2),
        v_cuenta_id INT,
        v_cuenta_anterior_id INT,
        v_categoria_id INT,
        v_nota VARCHAR(1000) = NULL
)
LANGUAGE plpgsql
AS $$
BEGIN

    -- Revertir transacción anterior --
    UPDATE cuentas 
    SET balance = balance - v_monto_anterior 
    WHERE cuenta_id = v_cuenta_anterior_id;

    -- Realizar nueva transacción --
    UPDATE Cuentas
    SET Balance = Balance + v_monto
    WHERE cuenta_id = v_cuenta_id;

    UPDATE Transacciones
    SET monto = ABS(v_monto), fecha_transaccion = v_fecha_transaccion,
    categoria_id = v_categoria_id, cuenta_id = v_cuenta_id, nota = v_nota 
    WHERE transaccion_id = v_transaccion_id;

    COMMIT;

END;
$$;

-- transacciones_borrar -- TODO
CREATE OR REPLACE PROCEDURE transacciones_borrar(
        -- Parametros de entrada del procedimietno almacenado
        v_transaccion_id INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_monto DECIMAL(18,2);
    v_cuenta_id INTEGER;
    v_tipo_operacion_id INTEGER;
    v_factor_multiplicativo INTEGER = 1;    
BEGIN

    SELECT tra.monto, tra.cuenta_id, cat.tipo_operacion_id
    INTO v_monto, v_cuenta_id, v_tipo_operacion_id
    FROM transacciones AS tra
    INNER JOIN categorias AS cat USING(categoria_id)
    WHERE tra.transaccion_id = v_transaccion_id;

    IF v_tipo_operacion_id = 2 THEN
        v_factor_multiplicativo := -1;
    END IF;

    v_monto := v_monto * v_factor_multiplicativo;

    UPDATE cuentas
    SET balance = balance - v_monto
    WHERE cuenta_id = v_cuenta_id;

    DELETE FROM transacciones
    WHERE transaccion_id = v_transaccion_id;

    COMMIT;

END;
$$;