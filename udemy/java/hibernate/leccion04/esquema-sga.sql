-- ESQUEMA DE LA BASE DE DATOS SGA alumnos

--
-- ASOCIACIONES
-- alumno * 1 domicilio
-- alumno * 1 contacto
-- alumno * * curso => lo cual => alumno 1 * asignacion & curso 1 * asignacion
-- 

--
-- Table structure for table `domicilio`
--

CREATE TABLE domicilio (
  id_domicilio SERIAL PRIMARY KEY,
  calle VARCHAR(45),
  no_calle VARCHAR(45),
  pais VARCHAR(45)
);

--
-- Table structure for table `contacto`
--

CREATE TABLE contacto (
  id_contacto SERIAL PRIMARY KEY,
  telefono VARCHAR(45),
  email VARCHAR(45)
);

--
-- Table structure for table `curso`
--

CREATE TABLE curso (
  id_curso SERIAL PRIMARY KEY,
  nombre VARCHAR(45),
  precio VARCHAR(45)
);

--
-- Table structure for table `alumno`
--

CREATE TABLE alumno (
  id_alumno SERIAL PRIMARY KEY,
  id_domicilio INTEGER DEFAULT NULL,
  id_contacto INTEGER DEFAULT NULL,
  nombre VARCHAR(45) DEFAULT NULL,
  apellido VARCHAR(45) DEFAULT NULL,
  CONSTRAINT fk_contacto FOREIGN KEY (id_contacto) REFERENCES contacto (id_contacto),
  CONSTRAINT fk_domicilio FOREIGN KEY (id_domicilio) REFERENCES domicilio (id_domicilio)
);

--
-- Table structure for table `asignación`
--

CREATE TABLE asignacion (
  id_asignacion SERIAL PRIMARY KEY,
  id_alumno INTEGER DEFAULT NULL,
  id_curso INTEGER DEFAULT NULL,
  turno VARCHAR(45),
  CONSTRAINT fk_alumno FOREIGN KEY (id_alumno) REFERENCES alumno (id_alumno),
  CONSTRAINT fk_curso FOREIGN KEY (id_curso) REFERENCES curso (id_curso)
);


--
-- Añadir inserciones
--
INSERT INTO domicilio VALUES (1,'Saturno','15','Mexico'),(2,'Candelaria','35','Colombia');
INSERT INTO contacto VALUES (1,'55443322','jperez@mail.com'),(2,'33221188','kgomez@mail.com');
INSERT INTO curso VALUES (1,'Fundamentos de Java',200),(2,'Java con JDBC',300);
INSERT INTO alumno VALUES (1,1,1,'Juan','Perez'),(2,2,2,'Karla','Gomez');
INSERT INTO asignacion VALUES (1,1,1,'Matutino'),(2,2,2,'Vespertino'),(3,1,2,'Vespertino');
