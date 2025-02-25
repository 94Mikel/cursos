# .NET

## Lenguaje C#

- C# es un lenguaje de programación **multiparadigmas**
- Con C# podemos desarrollar distintos tipos de app
- Es un lenguaje fuertemente tipado
- Es basado en clases
- Nos permite trabajar con fiones de primera clase
- LINQ y expresiones lambda

## ASP .NET Core framework

- ASP .NET Core es un framework para desarrollar aplicaciones
  web(multiplataforma)
- ASP significa Active Server Pages (para crear sistios web dinamicos)
- Sistema de ruteo
- Sitema de usuarios
- Inyección de dependencias
- Velocidad

### ASP .NET Core MVC

- MVC se refiere el patrón modelo-vista-controlador
- Un modelo se referiere a la data de nuestra aplicacion.
- Una vista se refiere a la plantilla que nuestra la data de un modelo.
- El controlador se encarga de acutalizar los modelos y la pasa los datos a
la vista que muestre el contenido final al usuario.

## Razon Pages

<https://learn.microsoft.com/es-es/aspnet/core/razor-pages/?view=aspnetcore-9.0&tabs=visual-studio>

- Es importante destacar que todo lo que tu hagas en MVC, lo puedes hacer en
  Razor Pages.
- El que recibe la petición es un page handler.

## Web APIs

- Usamos Web APIs cuando no queremos generar interfaces de usuario.
- Solo utiliza el modelo y controlador la vista se realiza aparte(distintos frontEnd).
- Puedes combinar MVC con Web APIs.

## Blazor

ASP .NET CORE y Blazor renderizan el html en el servidor y lo envian al cliente talcual.
Alternativa:

- Enviar código de C# al navegador del usuario.
- Blazor es una tecnología de ASP .NET Core que nos permite crear aplicaciones web interactivas.
- Con Blazor WebAssembly podemos enviar el código de C# al navegador del usuario y ejecutar ahí mismo.
- Con Blazor Server ejecutamos la aplicación remotamente desde un servidor.

## gRPC

- Es un framework que permite hacer llamadas de procedimiento remoto.
- La idea de gRPC es que nos permite comunicarnos de una manera muy rápida entre distintas aplicaciones.

## Front-End

- Parte que el usuario visualiza.
- html, css, js
- Con JavaScript poremos ejecutar un lenguaje de programación en el navegador
del usuario.

## Back-End

- La parte trasera de la aplicación.
- C# + base de datos.
