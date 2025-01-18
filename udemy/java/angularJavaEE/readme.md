# Angular & JavaEE
## Creación del backEnd con JavaEE y RESTFul Web Service
Realizado backEnd con EJB, JTA, JDBC, WebService...

## Cors

**CORS (Cross-Origin Resource Sharing)** es un mecanismo de seguridad utilizado por los navegadores web para controlar 
cómo se permite que un recurso de un dominio (origen) sea solicitado desde otro dominio. 
Este mecanismo protege a los usuarios de posibles ataques como el Cross-Site Request Forgery (CSRF), 
garantizando que sólo ciertas solicitudes estén permitidas.

### Contexto y Problema que Resuelve
En las aplicaciones web, las solicitudes HTTP que se realizan desde un dominio a otro 
(por ejemplo, desde mi-sitio.com hacia api.ejemplo.com) se consideran solicitudes de origen cruzado. 
Por defecto, los navegadores bloquean estas solicitudes si el servidor que recibe la solicitud no permite explícitamente el acceso. 
Este comportamiento se llama Same-Origin Policy (Política de Mismo Origen).

### Funcionamiento de CORS
- Cabeceras HTTP de CORS
El servidor que recibe una solicitud de origen cruzado responde con ciertas cabeceras HTTP que indican si la solicitud está permitida. 
Las cabeceras principales son:
	- Access-Control-Allow-Origin:
	
		Especifica qué dominios pueden acceder al recurso. 
		Puede ser un dominio específico (https://ejemplo.com) o un asterisco (*) para permitir todos los dominios.
	
	- Access-Control-Allow-Methods:

		Lista los métodos HTTP permitidos (por ejemplo, GET, POST, PUT, etc.).

	- Access-Control-Allow-Headers

		Define qué cabeceras específicas se permiten en las solicitudes.

	- Access-Control-Allow-Credentials

		Permite compartir cookies y credenciales con el dominio cruzado.

- Preflight Requests (Solicitudes de Preverificación)
Para solicitudes "no simples" (como aquellas que usan métodos distintos a  **GET** o **POST**, o que incluyen cabeceras personalizadas), 
el navegador primero realiza una solicitud preliminar al servidor usando el método **OPTIONS**.
Esta solicitud de preverificación pregunta al servidor si se permite la solicitud principal. 
El servidor responde con las cabeceras de **CORS** apropiadas.

### Ejemplo de Flujo de CORS
- Un cliente en el dominio https://mi-sitio.com intenta hacer una solicitud POST a https://api.ejemplo.com.
- El navegador detecta que es una solicitud de origen cruzado y, si no es una solicitud "simple", 
envía una solicitud de preflight OPTIONS al servidor en https://api.ejemplo.com.
- El servidor responde con cabeceras como:
	- Access-Control-Allow-Origin: https://mi-sitio.com
	- Access-Control-Allow-Methods: POST, GET
- Si las cabeceras de la respuesta son válidas, el navegador permite que la solicitud original continúe.

### Errores Comunes Relacionados con CORS
- **Falta de Cabeceras en el Servidor:** Si el servidor no incluye las cabeceras de CORS necesarias, el navegador bloqueará la solicitud.
- **Configuración Incorrecta del Origen:** Si Access-Control-Allow-Origin no incluye el dominio desde el que se realizó la solicitud, 
esta será rechazada.
- **Credenciales no Permitidas:** Si el servidor no habilita Access-Control-Allow-Credentials, las solicitudes con cookies fallarán.

### Soluciones Comunes
- **Configurar Correctamente el Servidor:** Asegurarse de que las cabeceras de CORS estén configuradas adecuadamente en el servidor.
- **Uso de Middleware en Frameworks Backend:** Muchos frameworks (como Express.js, Django o Spring Boot) ofrecen soluciones listas para manejar CORS.
- **Evitar Configuraciones Abiertas:** No usar Access-Control-Allow-Origin: * si las solicitudes incluyen credenciales.

