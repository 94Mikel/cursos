/**
 * Author:  mikel
 * Created: 4 may 2024
 */

CREATE TABLE persona (
    id_persona SERIAL PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(50),
    telefono VARCHAR(45)
);

INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Aitor', 'Garcia', 'aitorG@gmail.com', '688957485');
INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Pedro', 'Jimenez', 'pedroJ@gmail.com', '688957454');
INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Raul', 'Torres', 'raulT@gmail.com', '688677454');

CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    usuario VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO usuario(usuario, password) VALUES('javier','asdfg');
INSERT INTO usuario(usuario, password) VALUES('jon','qwerty');