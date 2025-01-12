# Spring

Spring Framework es un marco de trabajo (framework) de código abierto para la plataforma Java, 
ampliamente utilizado en el desarrollo de aplicaciones empresariales. 
Spring proporciona un ecosistema robusto que facilita el desarrollo de aplicaciones modernas, 
ofreciendo soporte para una amplia variedad de características, como la inyección de dependencias, 
programación orientada a aspectos, y la gestión de transacciones, entre otras.

A continuación, te explico en detalle los aspectos clave de Spring en Java:

## Inversión de Control (IoC) y Contenedor de Dependencias

La **IoC (Inversion of Control)** es uno de los pilares fundamentales de Spring. 
En lugar de que el código de la aplicación controle explícitamente la creación y la gestión de dependencias, Spring lo hace por ti. 
Esto se logra a través del contenedor IoC, que es responsable de:
- Crear y gestionar el ciclo de vida de los objetos (beans).
- Resolver y proporcionar las dependencias necesarias para los objetos.

Spring utiliza **Inyección de Dependencias (DI)** para configurar beans, lo que reduce el acoplamiento entre componentes.

## Programación Orientada a Aspectos (AOP)
Spring permite implementar AOP (Aspect-Oriented Programming), lo que facilita la separación de preocupaciones transversales, como:
- Logging (registro de eventos).
- Seguridad.
- Gestión de transacciones.

Por ejemplo, puedes usar anotaciones como @Aspect y @Around para interceptar métodos 
y ejecutar lógica adicional sin modificar el código original.

## Soporte para Transacciones
Spring facilita la gestión de transacciones en aplicaciones empresariales. Puedes usar anotaciones 
como **@Transactional** para definir los límites de una transacción.
Spring asegura que la transacción sea gestionada automáticamente, incluyendo el commit y rollback en caso de errores.

## MVC de Spring
Spring proporciona un marco web basado en el patrón Modelo-Vista-Controlador (MVC) llamado Spring MVC. 
Esto facilita la creación de aplicaciones web al gestionar solicitudes HTTP y enlazarlas a métodos de controladores.


## Spring Boot
Aunque el Spring Framework es poderoso, puede ser complejo configurar una aplicación desde cero. 
Para simplificar este proceso, Spring introdujo Spring Boot, que proporciona:
- Configuración automática (auto-configuration).
- Un servidor embebido (como Tomcat o Jetty).
- Dependencias gestionadas y listas para usar.

Por ejemplo, con Spring Boot puedes crear una aplicación funcional en minutos con pocas líneas de configuración.

## Soporte para Integraciones y Microservicios
Spring facilita la creación de microservicios a través de herramientas como:
- **Spring Cloud**, que soporta descubrimiento de servicios, configuración distribuida y circuit breakers.
- **Spring Data**, para trabajar con bases de datos de manera simplificada.
- **Spring Security**, para implementar autenticación y autorización.

## Ventajas de Spring
- **Flexibilidad**: Puedes usar solo los módulos que necesites.
- **Ecosistema completo**: Incluye soporte para tareas comunes en desarrollo empresarial.
- **Comunidad activa**: Es uno de los frameworks más utilizados en el mundo Java.

**Spring es ideal para aplicaciones empresariales debido a su capacidad para manejar proyectos complejos y escalables, 
y sigue siendo una elección popular para el desarrollo de aplicaciones
modernas.**

# Spring boot

Ya no es necesario configurar las applicaciones con los ficheros xml u otro
tipo de configuraciones ya que lo hace spring boot. Configuraciones como:
- Spring initializer.
- Crear aplicaciones de cualquier tipo: rest api, WebSocket, web streaming, tasks.
- Desarrollo para la seguridad => simplified security.
- Soporte para SQL Y NoSQL
- Servidores de aplicaciones de manera embebida como Tomcat, Jetty y Undertow.
- Soluciones como LiveReload que hace actualizar de manera automatica nuestra
aplicacion web.
- Al utilizar sistemas de administracion de librerias como maven o gradle
podemos utilizar cualquier IDE de nuestra preferencia. Como **Spring Tool
Suite**, **intelliJ IDEA** o **NetBeans**.

## Dependencias y Herramientas de desarrollo
- **Spring Boot DevTools**
	- Permite reiniciar mas facilmente nuestro servidor de aplicaciones
	  embebido de tomcat.
	- Utilizar LiveReload: Nos propociona el renicio de nuestra
	aplicaciones de manera automática en nuestro navegador.
	
- **Lombok**
	- Poryecto simple pero poderoso. Reduce código como son los metodos
	  get y set dentro de una clase java.
	- Podemos agregar de manera automatica el manejo de log4j a nuestra
	clase java.

## WEB
- Spring web
	- Nos permite crear aplicaciones de tipo REST y aplicaciones web
	  utilizando Sping MVC

## Template engines
- Thymeleaf
	- Nos permite agregar paginas web de manera mas simple a nuestras
	  aplicaciones con Spring. Ya no utilizaremos JSP-S sino
	  utilizaremos esta tecnologia.(tecnologia de presentacion).
	  Utilizaremos para desplegar la aplicaciones en html.

## Apache Netbeans Plugin Spring
Descargar plugin de spring desde la web de netbeans para crear proyectos de
Spring desde la netbeans.

NetBeans => tools => plugins => Downloaded => add plugins => file => open => install.
NbSpringBoot 3.0 => next => accept => install => continue => RestartIdeNow.

### Crear proyecto Spring desde netbeans
file => new proyect => java with maven => Spring boot initializer proyect

