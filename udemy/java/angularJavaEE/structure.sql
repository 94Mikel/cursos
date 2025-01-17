--- CREATE DATABASE test1

CREATE TABLE persona (
    id_persona SERIAL PRIMARY KEY,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    email VARCHAR(45),
    telefono VARCHAR(45)
);

INSERT INTO persona(nombre,apellido,email,telefono) VALUES('Juan','Perez','jperez@mail.com','22557744');
INSERT INTO persona(nombre,apellido,email,telefono) VALUES('Karla','Gomez','kgomez@mail.com','22556644');

