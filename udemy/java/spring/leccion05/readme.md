# CRUD

El término CRUD se refiere a las operaciones básicas que se realizan sobre una base de datos o cualquier sistema de almacenamiento. 
Es un acrónimo de las acciones:

- Create (Crear): Insertar nuevos registros.
- Read (Leer): Consultar datos existentes.
- Update (Actualizar): Modificar registros existentes.
- Delete (Eliminar): Borrar registros.

En el contexto de Spring Framework, CRUD se implementa comúnmente utilizando tecnologías como Spring Data JPA, Spring JDBC, o 
Hibernate para interactuar con bases de datos.

## CRUD en Spring Java
En aplicaciones Java basadas en Spring, CRUD se implementa generalmente mediante un enfoque en capas:

- Capa de Controlador (Controller): Gestiona las solicitudes HTTP.
- Capa de Servicio (Service): Contiene la lógica de negocio.
- Capa de Repositorio (Repository): Interactúa con la base de datos.

### Configuración inicial
- Dependencias en el proyecto
Configuración de pom.xml

- Configuración de la base de datos
En el archivo application.properties o application.yml, configura la base de datos.

### Crear una entidad
Las entidades representan tablas en la base de datos. Usa la anotación
**@Entity** para marcar una clase como una entidad JPA.

### Crear un repositorio
Usa la interfaz **JpaRepository** o **CrudRepository** para interactuar con la base de datos. 
Spring Data JPA generará automáticamente las implementaciones básicas de CRUD.

### Crear un servicio
La capa de servicio encapsula la lógica de negocio. Aquí puedes usar el repositorio para realizar operaciones.

### Crear un controlador
El controlador expone las operaciones a través de endpoints REST. 
Usa anotaciones como **@RestController** y **@RequestMapping** para definir las rutas.

### Probar los endpoints
Usa herramientas como Postman o cURL para probar los endpoints REST

## Resumen
El patrón CRUD en Spring Java sigue un diseño en capas para mantener la separación de responsabilidades:
- Entidad: Representa los datos en la base de datos.
- Repositorio: Proporciona métodos para interactuar con la base de datos.
- Servicio: Contiene la lógica de negocio.
- Controlador: Expone los endpoints REST.

