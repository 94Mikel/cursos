**Ejercicio:** Seguridad con Spring Framework
- Manejo de seguridad con Spring
- Seguridad con Spring y thymeleaf

# Spring Security
Spring Security es un marco potente y altamente personalizable que proporciona una solución integral para 
la seguridad de aplicaciones en el ecosistema Spring. 
En combinación con Thymeleaf, que es un motor de plantillas para construir interfaces de usuario dinámicas en aplicaciones web, 
se pueden implementar prácticas robustas de seguridad tanto a nivel de back-end como en la interfaz de usuario.

## Seguridad en Spring Security
Spring Security está diseñado para abordar tres áreas clave: autenticación, autorización y 
prevención de amenazas comunes (como ataques CSRF y XSS). 
A continuación, se describen los conceptos más importantes:

### Autenticación
La autenticación verifica la identidad del usuario. 
Spring Security ofrece múltiples formas de autenticación:
- **Autenticación basada en formularios:** Usa un formulario HTML para recoger las credenciales del usuario.
- **HTTP Basic o Digest Authentication:** Métodos estándar para enviar credenciales.
- **Autenticación OAuth2/OpenID Connect:** Usado para iniciar sesión con proveedores externos (Google, Facebook, etc.).
- **LDAP o bases de datos personalizadas:** Para verificar credenciales contra un directorio o base de datos.
- **JWT (JSON Web Tokens):** Para aplicaciones modernas, especialmente API REST.

### Autorización
La autorización se encarga de decidir si un usuario autenticado tiene permiso para realizar una acción específica. 
Spring Security ofrece:
- Configuración de permisos basada en roles (p. ej., ROLE_USER, ROLE_ADMIN).
- Seguridad basada en URL: Restringe el acceso a ciertas rutas según roles o autenticación.
- Seguridad basada en métodos: Uso de anotaciones como **@PreAuthorize** y
**@PostAuthorize** para proteger métodos a nivel de lógica de negocio.

### Prevención de amenazas
Spring Security incluye protección contra amenazas comunes:
- **CSRF (Cross-Site Request Forgery):** Genera tokens únicos para proteger solicitudes POST, PUT, DELETE.
- **XSS (Cross-Site Scripting):** Filtra contenido potencialmente malicioso.
- **Seguridad de encabezados HTTP:** Configura cabeceras como X-Content-Type-Options y Strict-Transport-Security.

## Seguridad con Spring y Thymeleaf
Cuando se combina Spring Security con Thymeleaf, se pueden gestionar permisos directamente en las vistas HTML. 
Esto mejora la seguridad en el lado del cliente al asegurarse de que el contenido sensible o 
las acciones restringidas no sean accesibles para usuarios no autorizados.

### Dependencias necesarias
- spring-boot-starter-security
- spring-boot-starter-thymeleaf
- thymeleaf-extras-springsecurity6
La última dependencia proporciona etiquetas adicionales de Thymeleaf para interactuar con Spring Security.

### Uso de etiquetas de seguridad en Thymeleaf
Thymeleaf ofrece un conjunto de atributos para mostrar o esconder contenido según el contexto de seguridad:
- **sec:authorize**: Este atributo se usa para renderizar contenido solo si se cumplen ciertas condiciones.
- **Manejo de la autenticación actual:** Puedes acceder al usuario autenticado y a sus detalles directamente
- **Mostrar/ocultar botones o enlaces**
- **Protección de formularios con CSRF:** Los formularios Thymeleaf incluyen automáticamente tokens CSRF si Spring Security está
habilitado.

### Configuración de seguridad en Spring
En la clase de configuración de seguridad (SecurityConfig), puedes personalizar cómo proteger las rutas y las
vistas.

## Ejemplo práctico
- Configura roles en la base de datos (o memoria).
- Protege rutas específicas en SecurityConfig.
- Usa Thymeleaf para mostrar dinámicamente contenido basado en roles o autenticación.





