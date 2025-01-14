# Introducción a Spring MVC y thymeleaf

- Hola mundo con Thymeleaf y Spring MVC
- Compartir información con Spring MVC y Thymeleaf
- Creación de clases de Dominio Persona
- Creación de una lista de personas

# Thymeleaf
Thymeleaf es un motor de plantillas (template engine) para Java diseñado para procesar y generar código HTML, XML, JavaScript, 
CSS e incluso texto plano. 
Es ampliamente utilizado en el desarrollo de aplicaciones web con Spring Framework, especialmente en proyectos de tipo Spring Boot. 
La principal ventaja de Thymeleaf es que permite crear vistas dinámicas que pueden combinarse fácilmente con lógica del lado del servidor.

## Características principales de Thymeleaf
- Naturaleza amigable al diseñador (natural templates):
	- Thymeleaf genera HTML que sigue siendo perfectamente válido y funcional para los navegadores, 
	incluso antes de ser procesado por el servidor.
	- Esto permite que los diseñadores web trabajen directamente con las plantillas 
	sin preocuparse por las instrucciones del servidor que agrega el desarrollador.
- Integración con Spring Framework:
	- Thymeleaf se integra de manera nativa con Spring MVC y Spring Boot, 
	utilizando el modelo de datos del controlador para renderizar las vistas dinámicas.
	- Soporta fácilmente el paso de datos del backend al frontend mediante el modelo Model de Spring.
- Lenguaje de expresiones (Thymeleaf Expression Language, o EL):
	- Utiliza un lenguaje de expresiones propio, similar al de JSTL o JSP.
	- Por ejemplo:
		- **${variable}**: Para acceder a atributos o datos del modelo.
		- ***{variable}**: Para trabajar dentro del contexto de un formulario.
		- **#{mensaje}**: Para internacionalización (i18n).
- Soporte para plantillas y fragmentos reutilizables:
	- Permite dividir el diseño en fragmentos reutilizables, como encabezados, pies de página o menús.
	- Usa etiquetas como <th:insert> y <th:replace> para incluir estos fragmentos.
- Dinámico y declarativo:
	- Thymeleaf incluye una serie de atributos personalizados (th:*) que permiten dinamismo en el
	  contenido, como:
		- **th:text**: Cambiar el contenido de texto.
		- **th:href**: Generar URLs dinámicas.
		- **th:if / th:unless**: Condiciones para mostrar/ocultar elementos.
		- **th:each**: Iterar sobre listas o colecciones.

## Cómo funciona Thymeleaf
- Plantilla base HTML:
	- Una página HTML estándar se utiliza como plantilla base. 
	Contiene etiquetas personalizadas de Thymeleaf (th:*) para definir cómo se comportará el contenido dinámico.
- Controlador en Java:
	- Los datos que necesita Thymeleaf se envían desde el backend mediante un controlador.
- Renderización:
	- El motor de plantillas reemplaza las expresiones de Thymeleaf con los valores proporcionados en el modelo 
	y genera el HTML final para el navegador.

## Ventajas de Thymeleaf
- Plantillas amigables para desarrolladores y diseñadores.
- Fácil de aprender y usar con Spring.
- Soporte nativo para fragmentos reutilizables.
- Integración con funciones avanzadas de internacionalización.
- Capacidades declarativas y dinámicas sin necesidad de script adicional.

## Desventajas de Thymeleaf
- No es ideal para aplicaciones de una sola página (SPA, como Angular o React).
- Puede ser menos eficiente que motores como JSP en aplicaciones con gran carga de procesamiento.
- La lógica compleja de renderización debe manejarse en el backend.

