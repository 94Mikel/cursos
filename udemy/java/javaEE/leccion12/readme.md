# Jaas
JAAS (Java Authentication and Authorization Service) es una API de Java que proporciona un marco para autenticar y 
autorizar usuarios en aplicaciones Java. 
Fue introducida en Java SE 1.4 y forma parte del núcleo de Java desde entonces. 
A continuación, te ofrezco una explicación detallada de JAAS:

## ¿Qué es JAAS?
JAAS es un API de seguridad diseñada para:
- **Autenticación**: Verificar la identidad de los usuarios que intentan acceder a una aplicación.
- **Autorización**: Controlar los permisos de los usuarios autenticados para realizar ciertas acciones.
JAAS permite separar la lógica de autenticación/autorización del código de negocio, proporcionando flexibilidad y modularidad.

## Componentes Clave de JAAS
- **LoginModule**
	- Una interfaz que define cómo se realiza la autenticación.
	- Implementaciones personalizadas pueden integrarse para autenticar contra bases de datos, LDAP, archivos, etc.
	- Ejemplo: com.sun.security.auth.module.LdapLoginModule.
- **Subject**
	- Representa la identidad de un usuario.
	- Contiene:
		- **Principals**: Representaciones del usuario (e.g., nombre de usuario).
		- **Credentials**: Información adicional, como contraseñas o tokens.
- **Principal**
	- Una interfaz que representa una entidad como un usuario o grupo.
	- Ejemplo: UserPrincipal, RolePrincipal.
- **LoginContext**
	- Proporciona un marco para interactuar con los LoginModules.
	- Administra la configuración, invoca los módulos de inicio de sesión, y autentica al usuario.
## Funcionamiento de JAAS
JAAS opera en dos fases principales:
- Autenticación:
	- Utiliza un LoginContext que coordina uno o más LoginModules.
	- Los módulos intentan autenticar al usuario y agregan información al Subject si la autenticación es exitosa.
- Autorización:
	- Después de la autenticación, se puede usar el Subject para verificar permisos mediante una política de seguridad.

## Configuración de JAAS
- Archivo de Configuración JAAS
Se define un archivo de configuración que especifica los módulos de inicio de sesión. Ejemplo
  jaas.config.
	- Control Flags:
		- required: El módulo debe autenticar, pero otros también deben ser considerados.
		- requisite: Si falla, se detienen los intentos.
		- sufficient: Si tiene éxito, no se evalúan más módulos.
		- optional: Se considera, pero no es obligatorio.
	- Propiedades del Sistema
		- El archivo de configuración se especifica como una propiedad del sistema:
			- System.setProperty("java.security.auth.login.config", "path/to/jaas.config");

## Implementación Básica de JAAS 
- LoginModule Personalizado
- LoginContext
- ConsoleCallbackHandler

## Ventajas de JAAS
- **Separación de lógica de autenticación/autorización.**
- **Extensibilidad**: Puedes crear tus propios LoginModules.
- **Independencia de Proveedores**: Compatible con múltiples sistemas de autenticación (LDAP, Kerberos, bases de datos).
- **Integración con Seguridad Java**: Utiliza políticas de seguridad (java.policy).

## Desventajas
- **Complejidad**: Puede ser difícil de configurar para principiantes.
- **API Antigua**: Aunque es poderosa, JAAS no está diseñada para escenarios modernos como OAuth2 o JWT, donde suelen usarse frameworks más específicos.

# Seguridad en la capa EJB

La seguridad en la capa **EJB (Enterprise JavaBeans)** es un aspecto esencial en el desarrollo de aplicaciones empresariales 
utilizando Java EE (ahora Jakarta EE). 
Esta capa gestiona la lógica de negocio y ofrece mecanismos integrados para proteger los componentes empresariales de accesos no autorizados 
y garantizar que las operaciones sean seguras.

## Aspectos clave de la seguridad en EJB
- Autenticación
	- La autenticación verifica la identidad del usuario o sistema que accede a los componentes EJB.
	- Utiliza las credenciales proporcionadas en la solicitud para autenticar al usuario en el servidor de aplicaciones.
- Autorización
	- La autorización se asegura de que los usuarios autenticados tengan los permisos necesarios para acceder a métodos específicos de un EJB.
	- Esto se logra definiendo roles y asociándolos con métodos o clases mediante configuraciones declarativas o programáticas.
	- Declarativa
		- Utiliza anotaciones en el código o configuraciones en el archivo ejb-jar.xml para definir las restricciones de acceso.
	- Programática
		- Permite controlar la autorización en tiempo de ejecución utilizando APIs como EJBContext.
- Transporte seguro
	- Los contenedores EJB pueden usar protocolos seguros como HTTPS para proteger la comunicación entre el cliente y el servidor.
	- Esto previene ataques como la intercepción de datos sensibles.
- Políticas de seguridad en el descriptor de despliegue
	- En el archivo ejb-jar.xml, se pueden configurar roles y restricciones sin modificar el código fuente.
- Control de acceso basado en roles (RBAC)
	- EJB utiliza un modelo de roles para asignar permisos a usuarios.
	- Los roles se definen en el código, en el descriptor de despliegue o en el servidor de aplicaciones.
- Contexto de seguridad del cliente
	- Proporciona información sobre el usuario que realiza la llamada, como su identidad y roles.
	- Esto es útil para registrar o personalizar el comportamiento en función del usuario.
- Seguridad transaccional
	- Protege la integridad de las transacciones, garantizando que las operaciones críticas no se vean afectadas por accesos maliciosos o fallas.

## Beneficios de la seguridad en EJB
- **Integración simplificada**: Los desarrolladores pueden confiar en las capacidades de seguridad del contenedor sin implementar mecanismos desde cero.
- **Portabilidad**: Las aplicaciones EJB con seguridad declarativa son fácilmente portables entre servidores de aplicaciones compatibles.
- **Cumplimiento normativo**: Los servidores de aplicaciones pueden configurar seguridad avanzada para cumplir con normativas como GDPR o HIPAA.

# Seguridad en JSF (Java Server Faces) y primefaces
La seguridad en JSF (JavaServer Faces) y PrimeFaces es crucial para proteger las aplicaciones web contra amenazas comunes 
y garantizar el acceso controlado a los recursos. 
Ambas tecnologías se basan en Java EE (ahora Jakarta EE), lo que permite aprovechar sus capacidades integradas de seguridad. 
A continuación, se explica en detalle cómo abordar la seguridad en cada uno de estos frameworks.

## Seguridad en JSF
JSF es un framework para construir aplicaciones web basadas en componentes. La seguridad en JSF abarca varios aspectos:
- Control de acceso basado en roles
	- JSF permite restringir el acceso a páginas o áreas de la aplicación según roles de usuario. 
	Los roles se definen en el servidor de aplicaciones y se utilizan para autorizar o denegar el acceso.
	- Este control puede aplicarse a nivel de URL (para restringir páginas completas) o mediante lógica de negocio en 
	los beans administrados (para habilitar o deshabilitar funcionalidades).
- Protección contra ataques comunes
	- **Cross-Site Scripting (XSS)**: JSF escapa automáticamente el contenido generado en sus componentes, 
	evitando que scripts maliciosos sean ejecutados en el navegador del usuario. 
	Sin embargo, es fundamental validar y sanear cualquier dato que provenga de entradas del usuario.
	- **Cross-Site Request Forgery (CSRF)**: A partir de JSF 2.2, el framework incluye un sistema de tokens para prevenir que un atacante 
	pueda realizar solicitudes maliciosas en nombre de un usuario legítimo.
	- **SQL Injection**: Aunque no es responsabilidad directa de JSF, los datos provenientes de formularios deben ser validados 
	antes de interactuar con bases de datos, asegurando que los valores sean tratados como datos y no como comandos SQL.
- Gestión de sesiones
	- JSF utiliza sesiones HTTP para rastrear el estado del usuario. 
	Para evitar ataques como el robo de sesión, es importante implementar medidas como la regeneración del 
	identificador de sesión tras el inicio de sesión y el uso de conexiones HTTPS.
	- También es fundamental manejar correctamente los tiempos de expiración de sesión para evitar accesos no autorizados.
- Configuración segura
	- La configuración de JSF debe estar optimizada para un entorno de producción. 
	Esto incluye deshabilitar mensajes de error detallados, habilitar comentarios mínimos en las páginas renderizadas y 
	proteger recursos estáticos sensibles.

## Seguridad en PrimeFaces
PrimeFaces es una biblioteca de componentes de interfaz de usuario para JSF. 
Al agregar características avanzadas a las aplicaciones JSF, introduce nuevas consideraciones de seguridad:

- Control de acceso a componentes
	- PrimeFaces facilita la creación de interfaces dinámicas, pero el acceso a los componentes visibles o 
	interactivos debe estar restringido según los permisos del usuario. 
	Por ejemplo, botones, menús o formularios deben habilitarse o deshabilitarse en función del rol del usuario.
- Protección contra ataques comunes
	- PrimeFaces hereda las medidas de protección de JSF contra XSS y CSRF. 
	Sin embargo, cuando se utilizan componentes avanzados como p:datatable o p:inputEditor, es importante validar y 
	escapar cualquier contenido dinámico, ya que estos pueden ser vectores de ataque si no se manejan adecuadamente.
	- Algunos componentes, como los editores de texto enriquecido, pueden permitir la inyección de contenido no deseado. 
	Para mitigar esto, se deben emplear bibliotecas adicionales para sanitizar la entrada del usuario.
- Gestión de archivos
	- PrimeFaces permite cargar y descargar archivos de forma sencilla. 
	Es esencial validar los tipos y tamaños de los archivos cargados para evitar ataques como la ejecución de scripts 
	o la sobrecarga del servidor.
	- Los archivos subidos deben almacenarse en ubicaciones seguras del servidor, fuera del alcance directo del cliente, 
	y ser procesados de manera segura.
- Protección de datos dinámicos
	- PrimeFaces permite una rica interacción en el lado del cliente mediante AJAX. 
	Aunque esto mejora la experiencia del usuario, puede introducir vulnerabilidades si los datos enviados o recibidos no están protegidos. 
	Por lo tanto, los datos sensibles deben cifrarse, y las respuestas del servidor deben validarse antes de ser utilizadas en el cliente.

## Mejores prácticas generales para JSF y PrimeFaces
- **Usar HTTPS**: Garantiza que toda la comunicación entre el cliente y el servidor esté cifrada, protegiendo datos sensibles.
- **Implementar un firewall de aplicaciones web (WAF)**: Ayuda a detectar y bloquear amenazas como XSS, CSRF y SQL Injection.
- **Minimizar la exposición de datos**: Evitar mostrar información confidencial o sensible en la interfaz o en el código fuente generado.
- **Auditorías y pruebas de seguridad**: Realizar evaluaciones periódicas de vulnerabilidades para identificar y mitigar posibles amenazas.
- **Mantener las bibliotecas actualizadas**: JSF y PrimeFaces deben estar en sus versiones más recientes para beneficiarse de parches de seguridad.

## Conclusion JSF Y primeFaces
La seguridad en JSF y PrimeFaces requiere un enfoque integral que combine las capacidades integradas de estos frameworks con 
las mejores prácticas generales de desarrollo web seguro. 
Esto incluye proteger la autenticación, la autorización, los datos transmitidos y almacenados, 
y garantizar que los usuarios solo accedan a los recursos que están autorizados a utilizar.

# Ejercicios
- Realizar autenticación con clientes
	- Cliente web
	- Cliente EJB
	- Cliente JAX-RS
	- Cliente JAX-WS
