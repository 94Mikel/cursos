# Manejos de Presupuestos

- Este proyecto va a ser una aplicación de manejo de presupuestos,
- Además de poder autenticarse, los usuarios van a poder registrar sus ingresos y gastos.
- Ofreceremos a nuestros usuarios una herramienta de reportería.
- Exportar a Excel.

## Curiosidades

- ctor => para crear el constructor automáticamente.

## Validaciones personalizadas

### Validaciones por atributo

Consisten en crear una clase de validación que vamos a poder reutilizar en distintos modelos.

### Validaciones por modelo

Las validaciones a nivel del modelo nos sirven para realizar validaciones dentro de la clase.

La ventaja de estas es que te permiten realizar validaciones complejas de varios campos.

La desventaja es que este tipo de validación esta acoplada al modelo en cuestión, lo que significa que no te permite reutilizar mucho código.

### Validaciones a nivel del controlador

Son validaciones que ocurren dentro de una acción.
Las usamos típicamente cuando las validaciones involucran bases de datos.

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

## Insertando un Tipo de Cuenta en la Base de Datos

Vamos ahora a colocar el código para insertar una cuenta en la base de datos.
Crearemos un servicio, es decir, una clase que vamos a porder utilizar con el sistema de inyecccion de dependencias.
La idea es que no queremos colocar el código de acceso a datos en nuestro controlador.
Para separar las responsabilidades de en la aplicación.

Cuando a una clase le llamamos repositorio es porque esta va a ser utilizada para acceder a una base de datos.

## Programación Asincrona

En c# un metodo pude ser sincrono a asincrono.

### Metodo sincrono

- Un metodo síncrono es aquel el cual, al ser ejecutado, debemos esperar a que termine y no podemos hacer nada mientras tanto.
- Un metodo sincrono es aquel que retorna al finalizar su procesamiento.

### Metodo asincrono

- Las funciones asíncronas se ejecutan y de inmediato retornan, aún si no han terminado de ejecutarse.
- La programación asíncrona la debemos utilizar cuando realizamos operaciones I/O(cuando nos relacionamos con otros sistema aparte).
- La ventaja de usar programación asíncrona es que nuestros sistemas son así mas eficientes.
- En C#, para urilizar programación asíncrona utilizamos async-await.
- Cuando la función asincrona finaliza resumimos la ejecución del código. Para poder utilizar awari tenemos que marcar el medio en donde éste se encuentra con Async.
- Un metodo asincrono retorna inmediatamente, aún sin haber terminado el procesamiento.
  - Retorna tipicamente un tipo de dato llamado task que representa una operación que va a finalizar en el futuro(una promesa).
- Combinando await y task es que podemos esperar de manera asincrónica la finalización de la tarea representada por Task.
