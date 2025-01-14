# Plantillas con thymeleaf
Thymeleaf es un motor de plantillas para aplicaciones Java que permite construir vistas dinámicas en aplicaciones web. 
Está diseñado para trabajar con HTML, XML y otros lenguajes de marcado, 
y es especialmente útil en proyectos que utilizan frameworks como Spring Boot.

A continuación, explico detalladamente el concepto de plantillas con Thymeleaf, su uso y principales características:

## ¿Qué es una Plantilla?
En el contexto de Thymeleaf, una **plantilla** es un archivo que contiene la estructura y el diseño de una página web (como un archivo HTML), 
combinado con instrucciones específicas de Thymeleaf para insertar datos dinámicos provenientes de una aplicación.

Por ejemplo:
- Una plantilla puede tener un encabezado, un pie de página y un cuerpo dinámico.
- Los datos se inyectan en la plantilla desde el controlador de tu aplicación.

## Características Principales de Thymeleaf
- Soporte para HTML válido:
	- Las plantillas de Thymeleaf son HTML válido incluso antes de ser procesadas.
	- Puedes abrirlas en un navegador o editor HTML sin problemas.
- Sintaxis natural y expresiva:
	- Usa atributos específicos (th:*) para manipular contenido dinámico.
	- Ejemplo: th:text, th:if, th:each.
- Integración con frameworks:
	- Funciona perfectamente con Spring MVC y Spring Boot.
	- Es compatible con controladores y modelos de datos.
- Soporte para Internacionalización (i18n):
	- Manejo de traducciones dinámicas para diferentes idiomas.
- Fragmentos reutilizables:
	- Permite definir partes comunes de una página (como encabezados y pies de página) en fragmentos reutilizables.

## Estructura de un Proyecto con Thymeleaf
Para usar Thymeleaf en un proyecto, debes incluirlo en tu aplicación. 

## Configuración de Thymeleaf en Spring Boot
Spring Boot configura Thymeleaf automáticamente si añades la dependencia correspondiente

## Uso Básico de Thymeleaf

- Plantilla HTML con Thymeleaf: 
	- El atributo th:text reemplaza el contenido del elemento con el valor de la variable
	  mensaje.
	- ${mensaje} indica que el dato proviene del modelo enviado desde el controlador.

- Controlador Spring Boot
	- El controlador envía datos dinámicos a la plantilla

## Atributos Comunes de Thymeleaf
- Mostrar datos dinámicos
	- th:text: Reemplaza el contenido de un elemento.
	- th:utext: Inserta contenido sin escapar (para HTML dinámico).
- Enlaces dinámicos
	- th:href: Genera URLs dinámicas.
	- th:src: Genera rutas dinámicas para recursos (imágenes, scripts, etc.).
- Condiciones
	- th:if y th:unless: Muestran o esconden elementos según una condición.
- Bucles
	- th:each: Itera sobre colecciones.

## Reutilización con Fragmentos
Thymeleaf permite dividir las plantillas en fragmentos reutilizables.
- Crear un fragmento
- Incluir un fragmento
	- th:insert: Incluye el fragmento.
	- :: headerFragment: Identifica una sección específica del fragmento.

## Internacionalización (i18n)
- **Archivos de mensajes:** Crea archivos de propiedades para los textos en diferentes idiomas
- **Uso en plantillas: ** Thymeleaf seleccionará automáticamente el idioma adecuado según la configuración regional del cliente.

## Ventajas de Usar Thymeleaf
- **HTML válido:** Las plantillas son completamente navegables y editables.
- **Fácil de aprender:** Usa conceptos familiares del desarrollo web.
- **Integración fluida:** Funciona perfectamente con Spring Boot y otros frameworks.
- **Reutilización y modularidad:** Fragmentos y herencia para componentes reutilizables.

## Limitaciones de Thymeleaf
- **Dependencia del lado del servidor:** Requiere renderización previa en el servidor, lo que puede ser menos eficiente para aplicaciones SPA.
- **Menor flexibilidad en el cliente:** Comparado con frameworks como React o Angular.

# Nueva sintaxis thymeleaf

## Nueva Sintaxis Recomendada:
<div th:replace="~{layout/plantilla :: header}"></div>

La nueva sintaxis utiliza ~{} para envolver la expresión del fragmento. Esto hace que la
intención sea más clara y consistente con otras expresiones de Thymeleaf.

### ¿Por Qué Usar la Nueva Sintaxis?
- **Compatibilidad Futura:** La sintaxis antigua será removida en futuras versiones de
Thymeleaf, por lo que es importante actualizar tu código para evitar problemas de
compatibilidad.
- **Claridad y Consistencia:** La nueva sintaxis hace que el código sea más legible y
consistente con otras expresiones de Thymeleaf.

