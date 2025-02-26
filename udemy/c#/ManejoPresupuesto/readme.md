# Manejos de Presupuestos

- Este proyecto va a ser una aplicación de manejo de presupuestos,
- Además de poder autenticarse, los usuarios van a poder registrar sus ingresos y gastos.
- Ofreceremos a nuestros usuarios una herramienta de reportería.
- Exportar a Excel.

## Validaciones personalizadas

- Validaciones por atributo

Consisten en crear una clase de validación que vamos a poder reutilizar en distintos modelos.

- Validaciones por modelo

Las validaciones a nivel del modelo nos sirven para realizar validaciones dentro de la clase.

La ventaja de estas es que te permiten realizar validaciones complejas de varios campos.

La desventaja es que este tipo de validación esta acoplada al modelo en cuestión, lo que significa que no te permite reutilizar mucho código.

## Comunicacion con la bd - Conection String

- Un conection string o cadena de conexión es un conjunto de valores relacionados con una base de datos y como acceder a ella.

Por ejemplo: El conexión string contiene el servidor donde se encuentra la base de datos.
También contiene el nombre de la base de datos a la cual queremos acceder.
También puede contener usuario password para acceder a la base de datos o si podemos utilizar las credenciales del sistema operativo para identificarnos a nivel de la base de datos.

Vamos a colocar ese connection string en un proveedor de configuración.

### Proveedor de configuración

Es un lugar doinde podemos colocar datos de configuración de nuestra aplicación, lo cual incluye conection string.

En desarrolo tenemos un coneccion string y en produccion tenemos otro. Por eso es importente tenerlo en un proveedo de configuración. Que se aun dato de la configuración del ambiente.

### Dapper

Dapper es una librería que nos permite trabajar la capa de acceso a datos de nuestras aplicaciones.
Capa de acceso a datos se refiere a la parte del código que se va a encargar de acceder a las fuentes de datos de la aplicación, que en nuestro caso es una base de datos psql.

Dapper nos ayudara a mapear lso resultados de un query a clases de  CSharp.
<https://aspnetcoremaster.com/dotnet/introduccion-a-dapper.html>

### Paso de conexión

- dotnet add package System.Data.SqlClient
- Añadir dapper en ManejoPresupuesto.csproj =>
PackageReference Include="Dapper" Version="21.35"
- dotnet add package npgsql.EntityFrameworkCore.PostgreSQL => añadir postgresql al proyecto
- dotnet add package npgsql.EntityFrameworkCore.PostgreSQL.Design => añadir postgresql al proyecto

