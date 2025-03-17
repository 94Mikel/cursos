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

### Validaciones con JavaScript Utilizando remote

Realizar accion especial, la cual va a servir para realizar esta validación.
Se utiliza el atributo remote para llamar dicha acción desde el navegador del usuario utilizando javaScript.
Remote es un atributo que nos permite realizar validaciones de manera remota, es decir, desde JavaScript(cliente) pero realizando una llamada hacia nuestra aplicación de ASP .NET CORE.

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

## jQuery UI

jQuery UI es una biblioteca de componentes construidos sobre la biblioteca jQuery que permiten desarrollar sobre un conjunto de plug-ins, widgets y efectos visuales preconstruidos para la creación de aplicaciones web. Cada componente o módulo se desarrolla de acuerdo a la filosofía de jQuery.

En esta aplicacion se utiliza shostable de jquery ui.

Para traer el jquery-ui a nuestro proyecto descargamos la libreria desde
<https://jqueryui.com/> y le damos a stable. Luego descomprimimos el archivo y lo movemos a wwwroot/lib/

## AJAX => Asynchronous JavaScript and XML

Es una técnica de desarrollo web para crear aplicaciones web asíncronas. Estas aplicaciones se ejecutan en el cliente, es decir, en el navegador de los usuarios mientras se mantiene la comunicación asíncrona con el servidor en segundo plano. De esta forma es posible interactuar con el servidor sin necesidad de recargar la página web, mejorando la interactividad, velocidad y usabilidad en las aplicaciones.

Ajax es una tecnología asíncrona, en el sentido de que los datos adicionales se solicitan al servidor y se cargan en segundo plano sin interferir con la visualización ni el comportamiento de la página, aunque existe la posibilidad de configurar las peticiones como síncronas de tal forma que la interactividad de la página se detiene hasta la espera de la respuesta por parte del servidor.

## Procedimiento alamacenado

Es un programa (o procedimiento) almacenado físicamente en una base de datos. Su implementación varía de un gestor de bases de datos a otro. La ventaja de un procedimiento almacenado es que al ser ejecutado, en respuesta a una petición de usuario, es ejecutado directamente en el motor de bases de datos, el cual usualmente corre en un servidor separado. Como tal, posee acceso directo a los datos que necesita manipular y sólo necesita enviar sus resultados de regreso al usuario, deshaciéndose de la sobrecarga resultante de comunicar grandes cantidades de datos salientes y entrantes.

Los procedimientos pueden ser ventajosos: cuando una base de datos es manipulada desde muchos programas externos. Al incluir la lógica de la aplicación en la base de datos utilizando procedimientos almacenados, la necesidad de embeber la misma lógica en todos los programas que acceden a los datos es reducida. Esto puede simplificar la creación y, particularmente, el mantenimiento de los programas involucrados.

## Resumen

- Vimos que podemos crear formularios que se sincronizan con modelos utilizando **tag helpers**.
- Vimos que podemos colocar **validadores** a nuestros modelos, las cuales podemos correr tanto front como en el back.
- Nos enteramos de que es una regla importante el **no confiar en la data** que nos llega desde el front. E implementamos distintos mecanismos para evitar que usuarios maliciosos realicen acciones indebidas.
- Aprendimos que la **programación asíncrona** nos permite ejecutar funciones que retornan una promesa de que habra una respuesta en el futuro. Esto hace que tengamos un software que haga varias tareas al mismo tiempo y se hace más eficiente.
- Realizamos un **crud** de nuestra entidad tipo cuentas.
- Aprendimos a **conectarnos con una base de datos** y utilizamos **dapper** para ejecutar cuadros y procedimientos almacenados desde nuestra aplicación de mvc.
- Vimos que podemos implementar una funcionalidad de arrastre de una manera bien sencialla con **jquery-ui**.
- Utilizamos el Fetch API para hacer peticiones http con JavaScript.

---

## Los otros CRUDs

### Entidad cuentas

#### Modelo

A traves de una cuenta, el usuario podrá manejar distintos balances, por ejemplo, una cuenta puede ser de banco, una tarjeta de crédito, un préstamo, etc.

- Creamos una clase con las mismas propiedades que nuestra tabla de cuentas.

#### Insertar cuentas

- Para insertar la cuenta en la bd necesitamos un repositorio de cuentas.
- Tambien necesitamos realizar un httpPost en cuentasController.

#### Indice de Cuentas

##### Query

- Ya que podemos grabar cuentas, hay que crear la funcionalidad de mostrar el listado de cuentas del usuario.
- Estas cuentas tienen que estar agrupadas por tipos de cuentas.
- Se realizara un cálculo de sumatoria total y por tipo cuenta de los distintos balances.

##### Vista

Implementamos la vista de nuestro indice de cuentas.
Vamos a agrupar cada cuenta agrupada por tipo de cuenta, mostrando los balances de las cuentas individules y por grupo.

#### Aislamiento css

El fichero custom.css es para toda la aplicacion. 
Es mejor utilizar el css para cada cshtml correspondiente para tener el diseño de la aplicacion ordenada.

### Mappeador

Un mapeador busca centralizar la lógica de copiado de datos entre objetos.
Esto evita que andemos repitiendo código de mapeo y además evita que tengamos que hacer dicho mapeo manualmente. Ya que es mejor automatizarlo para minimizar los posibles errores por descuido.
Un mapeado muy famoso en el mundo de .NET es **AutoMapper**.

Utilizaremos **AutoMapper** para evitar tener que hacer el mapeo manual:

- Instalar la libreria de AutoMapper => dotnet add package AutoMapper.
- A automapper hay que indicarle de que clase a que clase queremos mappear. 
- Lo hacemos en una clase profile.

La ventaja de utilizar AutoMapper es que te ahorras el tener que hacer el mapeo de manera manual. Esto hace que sea mas dificil cometer errores humanos.

### Categorías

Las categorías nos van a permitir indicar maneras de agrupar transacciones.
Ejemplo: No es lo mismo gastar 500 euros en pizza que un libro.
Es importante que los usuarios puedan no solamente registrar sus gastos, sino tambíen poder registrar en qué gastan su dinero.
Lo mismo para los ingresos.

### DropDown

Es un control de interface gráfica que permite a los usuarios seleccionar un elemento de una lista desplegable.
Dependiendo del framework de .NET que estés usando, hay diferentes controles de dropdown.

Su función principal es permitir la selección de un elemento dentro de una lista desplegable.

#### En ASP .NET con Razor

Se usa la etiqueta **select** en Razor con TagHelpers o **ViewData/ViewBag**.

### Resumen

- Trabajamos con los **CRUDs** de las demás entidades que componen nuestro proyecto. Creación, lectura, actualización y borrado de las demás entidades.
- Aprendimos a trabajar con **Drop Downs** o **select** para permitirle al usuario seleccionar una opción de varias opciones existentes.
- Vimos el **aislamiento de CSS** que nos permite tener reglas de estilo que sólo aplican a una vista en particular.
- **AutoMapper** para mapear nuestros objetos estre sí con un drop down cascada.
- Con **DropDown cascada** pudimos filtrar los valores de un dropdown en base a otro drop down.
- Vimos como trabajar con fechas en un formulario, tanto para trabajar con la hora como sin ella.

---

## Reportes

Con los repoetes los usuarios van a poder ver los resúmenes de sus movimientos para así saber a dónde se va su dinero.
