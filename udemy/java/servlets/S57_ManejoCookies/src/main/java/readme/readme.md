# Manejo de Cookies

## Ejercicio
Vamos a monitorear si un usuario ya ha hecho peticiones 
de manera recurrente a nuestro servidor.
En cuyo case vamos a detectar si ya lo hizo y le vamos a enviar un tipo de mensaje.
Por lo contrario, si es un usuario nuevo le vamos a dar la bienvenida a nuestro sitio web.

## Definicion

Se refiere a las técnicas y prácticas utilizadas para crear, enviar, recibir, 
y manipular cookies HTTP en aplicaciones web desarrolladas con Java, 
típicamente usando servlets y JavaServer Pages (JSP). 

Las cookies son pequeños fragmentos de datos que se almacenan en el navegador del usuario y 
se utilizan para mantener información entre las solicitudes HTTP, 
como las preferencias del usuario, las sesiones de usuario, y otros datos de estado.

El manejo de cookies en Java involucra las siguientes operaciones básicas:
- Creación de Cookies:
    - Crear una instancia de la clase javax.servlet.http.Cookie con un nombre y un valor.
- Envío de Cookies al Cliente:
    - Adjuntar la cookie a la respuesta HTTP para que sea enviada al navegador del cliente.
- Lectura de Cookies:
    - Recuperar las cookies enviadas por el cliente en las solicitudes subsecuentes.
- Manipulación de Cookies:
    - Modificar las propiedades de las cookies, como la duración, el dominio, la ruta, y la seguridad.


