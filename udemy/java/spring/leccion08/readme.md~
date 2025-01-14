# Manejo de mensajes e internacionalización con spring

El manejo de mensajes e internacionalización (i18n) en Spring Framework permite construir aplicaciones que admiten 
múltiples idiomas y configuraciones regionales (por ejemplo, monedas, formatos de fecha, etc.). 

A continuación, se explica detalladamente cómo funciona este proceso y cómo configurarlo en una aplicación Spring o Spring Boot.

## Conceptos Clave
- Internacionalización (i18n):
Se refiere al proceso de diseñar una aplicación para que pueda ser traducida fácilmente a diferentes idiomas 
y adaptada a configuraciones regionales.

- Localización (l10n):
Es el proceso de adaptar una aplicación internacionalizada a un idioma o configuración regional específica.

- Locale:
Representa una configuración regional que incluye información como idioma, país y formato de datos.

## Configuración de Mensajes e Internacionalización en Spring Boot
- Archivos de Mensajes
Spring utiliza archivos de propiedades (.properties) para almacenar los mensajes traducibles. 
Cada archivo de mensajes está asociado con un idioma y, opcionalmente, con un país.

**Ejemplo de archivos de mensajes:**
	- Archivo por defecto (messages.properties)
	- Archivo en inglés (messages_en.properties)
	- Archivo en francés (messages_fr.properties)

- Estructura del Proyecto
Los archivos de mensajes se colocan en src/main/resources para que estén disponibles en el classpath. 

- Configuración de Internacionalización en Spring Boot
Spring Boot proporciona una configuración automática para la internacionalización. 
Solo necesitas habilitarla y personalizar algunos aspectos si es necesario.

**Configurar un LocaleResolver:** El LocaleResolver define cómo determinar el idioma y la configuración regional del usuario.

**Habilitar un Interceptor para Cambiar el Idioma:** El **LocaleChangeInterceptor** permite cambiar el idioma dinámicamente a través de un parámetro en la URL.

## Uso de Mensajes en la Aplicación

- Obtener Mensajes desde Archivos de Propiedades

Spring permite acceder a los mensajes mediante la clase MessageSource.

**Configurar el MessageSource:** Si usas Spring Boot, no es necesario configurarlo manualmente porque ya viene integrado con **ResourceBundleMessageSource**

**Ejemplo de Uso en Controladores:** Puedes inyectar **MessageSource** para obtener mensajes dinámicamente según el idioma

messageSource.getMessage("saludo", null, locale) busca el mensaje con clave saludo en el idioma definido por locale.

- Uso de Mensajes en Plantillas Thymeleaf
En plantillas Thymeleaf, puedes usar el prefijo #{} para acceder a los mensajes

## Cambio Dinámico de Idioma

Si implementaste el **LocaleChangeInterceptor**, puedes cambiar el idioma dinámicamente agregando un parámetro a la URL:
Por ejemplo:
- / => Usa el idioma predeterminado (es).
- /?lang=en => Cambia al inglés.
- /?lang=fr => Cambia al francés.

## Internacionalización de Fechas y Números
Además de mensajes, puedes formatear fechas y números según el idioma y la configuración regional.

- Formato de Fechas con Thymeleaf
- Formato de Números con Thymeleaf
