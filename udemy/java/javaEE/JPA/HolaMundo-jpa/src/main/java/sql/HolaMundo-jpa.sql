/**
 * Author:  mikel
 * Created: 24 jun 2024
 */

CREATE TABLE persona (
    id_persona INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    email VARCHAR(45),
    telefono VARCHAR(45)
);
