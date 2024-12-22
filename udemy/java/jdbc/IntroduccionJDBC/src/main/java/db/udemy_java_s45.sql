/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
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

