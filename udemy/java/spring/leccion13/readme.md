# Ejercicio: Aplicación final Spring Boot con Bootstrap
- Agregar librerias de Bootstrap, FontAwesome y WebJars
- Agregando bootstrap a nuestra aplicacion de Spring
- Agregando barra de menu con bootstrap
- Agregando el Header y Footer con Bootstrap
- Manejando el Login con Bootstrap
- Botón de agregar
- Modificación tabla persona
- Mejora de listado de clientes
- Agregar un nuevo cliente
- Botones de editar
- Modificar Cliente

## WebJars

WebJars es un formato para empaquetar recursos front-end (como CSS, JavaScript, imágenes, etc.) en archivos JAR. 
Estos JAR son compatibles con herramientas de gestión de dependencias como Maven y Gradle, 
lo que permite gestionar bibliotecas de front-end (por ejemplo, Bootstrap, jQuery, FontAwesome) 
de la misma manera que gestionamos bibliotecas Java.

### ¿Por qué usar WebJars?
- **Gestión de dependencias centralizada:** Usar WebJars permite administrar las bibliotecas de front-end directamente desde el archivo 
pom.xml o build.gradle.
- **Versionado automático:** Facilita la actualización de versiones, 
ya que cada WebJar contiene la versión específica de la biblioteca que deseas usar.
- **Compatible con Spring Boot y otros frameworks:** Spring Boot maneja automáticamente los recursos estáticos de WebJars.
- **Integración con sistemas de construcción:** Funciona bien con Maven y Gradle, 
eliminando la necesidad de herramientas adicionales como NPM o Yarn.

### Tipos de WebJars
- **Classic WebJars:** Estos son WebJars empaquetados manualmente por la comunidad. 
Contienen las bibliotecas front-end con una estructura predefinida.
- **Bower WebJars:** Estos se generan automáticamente desde paquetes Bower
- **NPM WebJars:** Estos se generan automáticamente desde paquetes NPM. 

### ¿Cómo usar WebJars en una aplicación Spring Boot?
- Agrega las dependencias en pom.xml
- Configura Spring Boot para servir recursos estáticos

Spring Boot ya está configurado para manejar WebJars automáticamente. Los recursos estáticos se sirven desde:
/webjars/{library}/{version}/{path}

- Usa los recursos en tus plantillas Thymeleaf
Con la dependencia webjars-locator-core, puedes usar rutas dinámicas para evitar especificar manualmente la versión de las bibliotecas
Thymeleaf resolverá automáticamente las rutas a las versiones correspondientes.

### Diagnóstico y solución de problemas comunes
- 404 al acceder a los recursos WebJars
	- Verifica que la dependencia esté correctamente especificada en pom.xml.
	- Asegúrate de que el archivo JAR esté presente en el repositorio local (~/.m2/repository).
	- Comprueba que el archivo está en la ruta correcta dentro del JAR (META-INF/resources/webjars).
- No resource with given identifier found
	- Este error ocurre si el recurso solicitado no existe o no se encuentra en la ruta esperada. 
	Revisa la URL en el navegador y confirma que la estructura de rutas es correcta.
- Rutas no resueltas dinámicamente
	- Si usas rutas como @{/webjars/...} y no funcionan, asegúrate de incluir webjars-locator-core como dependencia en tu proyecto.

### Ventajas de WebJars
- **Sin dependencias externas:** No necesitas instalar Node.js, NPM, o Yarn para gestionar dependencias front-end.
- **Versionado simplificado:** Controlas las versiones directamente desde pom.xml.
- **Integración perfecta con Spring Boot:** Funciona de manera nativa con Spring para servir recursos estáticos.
- **Caché y rendimiento:** Los recursos pueden ser almacenados en caché eficientemente por los navegadores.

### Alternativa: ¿Cuándo usar un CDN en lugar de WebJars?
Aunque WebJars es útil, en algunos casos un CDN puede ser más adecuado:
- **Entornos de producción:** Los CDNs como jsdelivr o cdnjs ofrecen tiempos de respuesta más rápidos y manejo de caché global.
- **Minimización de peso:** Los CDNs a menudo sirven recursos optimizados y distribuidos.

## BootStrap

Bootstrap es un framework front-end de código abierto diseñado para facilitar el desarrollo de sitios y aplicaciones web. 
Fue creado por desarrolladores de Twitter y se lanzó en 2011. 
Proporciona un conjunto de herramientas predefinidas basadas en HTML, CSS y JavaScript que permiten a los desarrolladores crear interfaces modernas, 
responsivas y consistentes de manera eficiente.

A continuación, se explica en detalle:

### Características Principales de Bootstrap

Bootstrap es conocido por varias características clave que lo hacen popular entre desarrolladores:

#### Diseño Responsivo
- Bootstrap usa un sistema de cuadrícula (grid system) basado en flexbox que facilita la creación de 
diseños responsivos adaptados a diferentes tamaños de pantalla.
- Las clases como col-sm-, col-md-, col-lg- y col-xl- ajustan la disposición de los elementos según el ancho de la pantalla.

#### Estilos Predefinidos
Bootstrap incluye una biblioteca de estilos CSS que puede aplicarse fácilmente mediante clases. 
Esto abarca botones, formularios, tablas, tarjetas, alertas, y mucho más.

#### Componentes Reutilizables
Bootstrap proporciona una amplia gama de componentes reutilizables, como:
- **Navbars:** Barras de navegación.
- **Cards:** Tarjetas para mostrar contenido.
- **Modals:** Ventanas emergentes.
- **Carousels:** Carruseles de imágenes.
- **Tooltips:** Descripciones flotantes.

#### Compatibilidad con Navegadores
Bootstrap es compatible con los navegadores modernos y asegura una experiencia uniforme entre ellos.

#### Soporte para JavaScript
Incluye componentes basados en JavaScript (ya sea con vanilla JS o integrados con frameworks como React y Vue). 
Algunos de estos componentes son modales, acordeones, dropdowns, y tooltips.

### Sistema de Cuadrícula
El sistema de cuadrícula es la base del diseño de Bootstrap. Está compuesto por contenedores, filas y columnas.

#### Estructura Básica
- **Container:** Define el área máxima para el contenido (.container o .container-fluid).
- **Row:** Define filas que agrupan columnas.
- **Col:** Divide el espacio disponible en columnas. Bootstrap usa un sistema de 12 columnas por fila.

### CSS en Bootstrap

#### Tipografía
Bootstrap incluye estilos predeterminados para texto, encabezados, párrafos, listas 

#### Colores
Bootstrap tiene una paleta de colores estándar que se utiliza para botones, fondos, bordes y textos. Algunos ejemplos:
- text-primary, text-secondary, text-success
- bg-primary, bg-secondary

#### Espaciado
Se utiliza una convención basada en m (margin) y p (padding), seguida de un tamaño (1 a 5).

### JavaScript en Bootstrap
Bootstrap incluye componentes interactivos que requieren JavaScript. 
Pueden ser controlados mediante atributos de datos (data-*) o mediante JavaScript.

### Cómo Empezar con Bootstrap
#### Incluir Bootstrap
- Usa un CDN para cargar Bootstrap rápidamente
- O instala Bootstrap con npm
#### Personalización
- Puedes sobrescribir los estilos de Bootstrap con CSS personalizado.
- También puedes usar Sass para modificar las variables predeterminadas de Bootstrap y crear una versión personalizada.

### Ventajas y Desventajas

#### Ventajas
- Acelera el desarrollo con componentes reutilizables.
- Sistema responsivo robusto.
- Amplia documentación y comunidad.
- Fácil integración con otros frameworks.

#### Desventajas
- El diseño puede volverse genérico si no se personaliza.
- Puede incluir más código del necesario, aumentando el tamaño del proyecto.

En resumen, Bootstrap es una herramienta ideal para desarrolladores que desean construir sitios web responsivos y modernos de manera eficiente, 
sin empezar desde cero. 
Sus características predefinidas y extensibilidad lo convierten en uno de los frameworks front-end más utilizados.


## Font Awesome
Font Awesome es una biblioteca de iconos ampliamente utilizada en desarrollo web que permite agregar iconos escalables a aplicaciones y sitios web. 
Los iconos de Font Awesome se implementan como fuentes o vectores SVG, lo que los hace altamente personalizables.

### Características principales de Font Awesome
- Gran cantidad de iconos:
	- Incluye una amplia variedad de iconos categorizados (sociales, de interfaz, multimedia, etc.).
	- Compatible con diferentes estilos: sólido, regular, light, y marcas (brands).
- Escalabilidad:
	- Los iconos se representan como vectores, lo que permite escalarlos sin pérdida de calidad.
- Personalización:
	- Fácil de cambiar el tamaño, color, o aplicar animaciones mediante CSS.
- Compatibilidad:
	- Funciona en la mayoría de los navegadores modernos.
	- Compatible con frameworks como Bootstrap y React.

### Cómo usar Font Awesome
- Mediante CDN: Puedes incluir Font Awesome fácilmente en tu proyecto usando un enlace de CDN.
- Mediante instalación local: Si usas npm

### Ventajas de Font Awesome
- Gran flexibilidad en el diseño.
- No requiere imágenes adicionales, ya que los iconos son fuentes o SVG.
- Compatible con accesibilidad mediante atributos como aria-hidden="true".

## WebJars
WebJars es un mecanismo para gestionar bibliotecas web como dependencias de tu proyecto en entornos basados en Java. 
Específicamente, empaqueta bibliotecas de front-end como archivos JAR que pueden ser usados directamente en aplicaciones.

### Características principales de WebJars
- Gestión centralizada de dependencias:
	- Permite incluir bibliotecas front-end como Bootstrap, jQuery, Font Awesome, etc., desde repositorios Maven.
- Compatibilidad con entornos Java:
	- Ideal para aplicaciones basadas en Spring Boot, JHipster, o cualquier framework que use Maven o Gradle.
- Integración simplificada:
	- Las bibliotecas se descargan e incluyen automáticamente en el proyecto.

### Cómo usar WebJars
- Agregar una dependencia en Maven o Gradle
- Acceso a los recursos en tu aplicación
	- Los recursos se sirven desde el contexto de /webjars.

### Ventajas de WebJars
- Gestiona versiones automáticamente y las descarga desde repositorios confiables.
- Simplifica la integración de bibliotecas front-end en aplicaciones Java.
- Reduce la necesidad de gestionar manualmente archivos CSS o JS.

### Limitaciones
- Depende de un ecosistema Java.
- Puede no ser tan directo como los CDNs en proyectos pequeños.

---

### Relación entre Font Awesome y WebJars 	 
- Font Awesome está disponible como WebJar, lo que facilita su inclusión en proyectos Java
- De esta forma, puedes combinar las ventajas de Font Awesome (diseño de iconos) con la gestión de dependencias de WebJars en entornos Java.