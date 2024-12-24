/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  mikel
 * Created: 23 dic 2024
 */

CREATE TABLE persona (
    id_persona SERIAL PRIMERY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(50),
    telefono VARCHAR(45)
);

CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    id_persona INTEGER NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona) ON DELETE SET NULL,
    username VARCHAR (45);
    passwor VARCHAR (45);
);

INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Pepe','Bilbao','asdf@asd.com','685457521');
INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Maria','Gutierrez','mgutierrez@asd.com','685525369');

INSERT INTO usuario(id_persona, username, password) VALUES(1, 'pepe', '545234');
INSERT INTO usuario(id_persona, username, password) VALUES(2, 'maria', '5423523');



