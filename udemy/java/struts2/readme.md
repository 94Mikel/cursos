# Struts
Apache Struts es un **framework de código abierto** para el desarrollo de aplicaciones web en
**Java EE (Enterprise Edition)** basado en el patrón **MVC (Modelo-Vista-Controlador)**. 
Struts facilita la creación de aplicaciones web estructuradas 
y mantenibles al separar la lógica de negocio, la presentación y el flujo de control.

## Características principales de Struts:
- Basado en el patrón MVC:
	- Modelo: Gestiona los datos y la lógica de negocio (normalmente utilizando JavaBeans o POJOs).
	- Vista: Usa tecnologías como JSP (JavaServer Pages) para presentar la información al usuario.
	- Controlador: Gestiona las solicitudes del usuario y las dirige a los componentes adecuados.
- Configuración basada en XML:
	- El flujo de la aplicación se define en archivos de configuración como struts-config.xml.
- Interoperabilidad con tecnologías Java:
	- Soporte para servlets, JSP, JDBC, EJB y otros componentes de Java EE.
- Facilidad de validación de formularios:
	- Incluye un framework de validación que permite definir reglas de validación de datos en XML o código Java.
- Etiquetas personalizadas (Tag Libraries):
	- Struts proporciona una serie de etiquetas (<html:form>, <html:text>), que facilitan el desarrollo de formularios web.
- Soporte para i18n (internacionalización):
	- Permite el desarrollo de aplicaciones en múltiples idiomas.
- Control centralizado mediante el ActionServlet:
	- Gestiona todas las solicitudes de los clientes y las redirige a las clases de acción correspondientes.

## Versiones de Struts:
Apache Struts ha evolucionado a lo largo del tiempo con dos versiones principales:
- Struts 1 (descontinuado):
	- Usaba servlets y una arquitectura más rígida.
	- Configuración pesada mediante XML.
	- Uso intensivo de clases de acción específicas.
- Struts 2 (versión actual):
	- Basado en el framework WebWork.
	- Simplifica la configuración mediante anotaciones en lugar de archivos XML.
	- Uso de Inyección de Dependencias con Spring.
	- Mejora en la integración con AJAX y JSON.
	- Mejor manejo de interceptores para la manipulación de solicitudes.

## Arquitectura de Struts
- **Solicitud del cliente:** Un usuario realiza una solicitud HTTP a través de un navegador.
- **Controlador (ActionServlet):** Procesa la solicitud y la dirige a la acción correspondiente.
- **Acción (Action Class):** Gestiona la lógica de negocio, interactúa con el modelo (por ejemplo, una base de datos).
- **Vista (JSP):** Devuelve la respuesta procesada al cliente.

## Ciclo de vida de una solicitud en Struts:
- El usuario envía una solicitud desde el navegador.
- El ActionServlet recibe la solicitud y la procesa con base en el archivo struts-config.xml.
- Se ejecuta la acción correspondiente mediante la clase de acción (Action).
- Se obtiene el resultado, se selecciona la vista adecuada y se genera la respuesta (JSP o JSON).
- La respuesta se devuelve al usuario en el navegador.

## Ventajas de usar Struts:
- Separación clara de la lógica de negocio y la presentación (MVC).
- Soporte para la reutilización de código mediante ActionForms y validaciones.
- Integración sencilla con frameworks como Hibernate y Spring.
- Amplia comunidad de soporte y documentación.

## Desventajas de usar Struts:
- Configuración extensa, especialmente en versiones anteriores (Struts 1).
- Mayor curva de aprendizaje en comparación con frameworks más modernos como Spring Boot.
- Struts ha sido reemplazado en muchas aplicaciones modernas por frameworks más ligeros y flexibles.

## Alternativas modernas a Struts:
Aunque Struts sigue siendo utilizado en aplicaciones empresariales, hoy en día existen alternativas más modernas, como:
- **Spring Boot**: Más modular y con soporte completo para microservicios.
- **JSF (JavaServer Faces)**: Un framework más orientado a la presentación con componentes visuales.
- **Quarkus/Micronaut**: Frameworks ligeros diseñados para microservicios y cloud.