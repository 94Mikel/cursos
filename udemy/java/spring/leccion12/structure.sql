CREATE TABLE persona (
    id_persona SERIAL PRIMARY KEY,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    email VARCHAR(45) UNIQUE,
    telefono VARCHAR(45)
);

CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    username VARCHAR(45),
    password VARCHAR(128)
);

CREATE TABLE rol (
    id_rol SERIAL PRIMARY KEY,
    nombre VARCHAR(45),
    id_usuario INTEGER,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario)
    REFERENCES usuario(id_usuario)
);

INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Pepe','Ramirez','pramirez@mail.com', '77889966');
INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Iker','Bilbao','ibilbao@mail.com','22558877');
INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Ane','Garcia','ggarcia@mail.com','11223344');

INSERT INTO usuario(username, password) VALUES('admin','123');
INSERT INTO usuario(username, password) VALUES('usuario','123');

INSERT INTO rol(nombre, id_usuario) VALUES('ROLE_ADMIN',1);
INSERT INTO rol(nombre, id_usuario) VALUES('ROLE_USER',2);
INSERT INTO rol(nombre, id_usuario) VALUES('ROLE_USER',2);


