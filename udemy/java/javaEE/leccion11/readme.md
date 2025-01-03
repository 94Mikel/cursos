# REST Web Service

Un REST Web Service (Servicio Web RESTful) es una implementación de servicios web que utiliza el estilo 
arquitectónico REST (Representational State Transfer). 
En Java, esto implica crear una aplicación que pueda interactuar con clientes a través de protocolos HTTP y 
manejar datos en formatos como JSON o XML. 
A continuación, te explico en detalle cómo funcionan los servicios web REST en Java:

## Conceptos Clave de REST
REST se basa en:
- **Recursos**: Representan entidades o datos, como usuarios, productos o pedidos. Cada recurso tiene una URI única.
	- Ejemplo: **https://api.ejemplo.com/usuarios/123** representa el usuario con ID 123.
- **Métodos HTTP**: Utilizan verbos HTTP para realizar acciones específicas sobre los recursos:
	- GET: Recuperar datos.
	- POST: Crear un nuevo recurso.
	- PUT: Actualizar un recurso existente.
	- DELETE: Eliminar un recurso.
	- PATCH: Actualizar parcialmente un recurso.
- **Representaciones**: Los datos de los recursos se transfieren en formatos como JSON, XML, o texto plano.

## Frameworks Populares en Java
En Java, varios frameworks facilitan la creación de servicios RESTful:
- **JAX-RS (Java API for RESTful Web Services):**
	- Es una especificación estándar de Java EE/Jakarta EE para construir servicios REST.
	- Implementaciones populares: Jersey, RESTEasy, Apache CXF.
- **Spring Boot y Spring Web:**
	- Facilita la creación de servicios REST con anotaciones y configuración mínima.

## Buenas Prácticas
- **Validación de Datos**: Usa anotaciones como @Valid y @NotNull para validar las entradas.
- **Excepciones Personalizadas**: Crea controladores de excepciones para manejar errores globalmente.
- **Seguridad**: Implementa autenticación y autorización, por ejemplo, con Spring Security o JWT.
- **Documentación**: Usa herramientas como Swagger/OpenAPI para documentar automáticamente tus servicios.

# JAX-RS
JAX-RS (Java API for RESTful Web Services) es una especificación en el ecosistema Java que simplifica la creación de servicios web RESTful. 
Está incluida en Jakarta EE (anteriormente Java EE) y proporciona una API estándar basada en anotaciones para desarrollar aplicaciones que 
implementen el estilo arquitectónico REST.

Aquí te ofrezco una explicación completa de JAX-RS:

## ¿Qué es JAX-RS?
JAX-RS es una especificación, lo que significa que define cómo deben comportarse las implementaciones sin proporcionar una implementación específica. 
Algunas de las implementaciones populares de JAX-RS incluyen:
- **Jersey**: Referencia oficial. (Ejercicio realizado con esto)
- **RESTEasy**: Proyecto de Red Hat.
- **Apache CXF**: Solución empresarial robusta.

JAX-RS está diseñada para que los desarrolladores puedan enfocarse en las funcionalidades RESTful sin preocuparse por los detalles del protocolo HTTP.

## Anotaciones Clave en JAX-RS
Las anotaciones son el núcleo de JAX-RS, y permiten mapear las solicitudes HTTP a métodos Java.

- Anotaciones para Mapear Rutas
	- **@Path**: Define la URI del recurso.
- Anotaciones para Métodos HTTP
	- **@GET**: Maneja solicitudes HTTP GET.
	- **@POST**: Maneja solicitudes HTTP POST.
	- **@PUT**: Maneja solicitudes HTTP PUT.
	- **@DELETE**: Maneja solicitudes HTTP DELETE.
	- **@PATCH**: Maneja solicitudes HTTP PATCH (no está en JAX-RS 2.1 pero puede manejarse).
- Anotaciones para Parámetros
	- **@PathParam**: Extrae valores de la URI.
	- **@QueryParam**: Extrae valores de los parámetros de consulta.
	- **@HeaderParam**: Extrae valores de los encabezados HTTP.
	- **@FormParam**: Extrae datos enviados en formularios.
- Otras Anotaciones
	- **@Consumes**: Especifica el tipo de datos que el recurso puede aceptar (e.g., JSON, XML).
	- **@Produces**: Especifica el tipo de datos que el recurso devuelve.

## Arquitectura de JAX-RS
Un servicio REST en JAX-RS consta de varios elementos:
- **Recursos**: Clases que representan entidades y están anotadas con @Path.
- **Métodos**: Manejan las solicitudes HTTP y están anotados con verbos HTTP (@GET, @POST, etc.).
- **Proveedores**: Clases que manejan tareas como conversión de datos, excepciones, y filtros.
	- Ejemplo: MessageBodyReader y MessageBodyWriter para procesar JSON o XML.

## Ejemplo Completo con Jersey (Implementación de JAX-RS)
Supongamos que estamos creando un servicio REST para manejar usuarios.
- Configuración del Proyecto
	- Añade las dependencias en tu archivo pom.xml (si usas Maven)
	- Configura el archivo web.xml para registrar tu aplicación
- Código Java
	- Modelo
	- Recurso REST

## Ejecución
- Despliega tu aplicación en un servidor compatible con Jakarta EE (como GlassFish o Payara).
- Prueba las rutas con herramientas como Postman:
	- GET /api/usuarios
    	- POST /api/usuarios
	- PUT /api/usuarios/{id}
    	- DELETE /api/usuarios/{id}

## Ventajas
- **Simplicidad**: Uso extensivo de anotaciones.
- **Estandarización**: Compatible con cualquier servidor Jakarta EE.
- **Flexibilidad**: Personalización a través de proveedores y filtros.

# Ejercicio
- Service JAX-RS.
- Proceso completo de como crear un rest web service y cliente respectivo.

