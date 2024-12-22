
/**
 * Author:  mikel
 * Created: 3 jun 2024
 */

CREATE TABLE cliente (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    email VARCHAR(45),
    telefono VARCHAR(45),
    saldo FLOAT 
);
