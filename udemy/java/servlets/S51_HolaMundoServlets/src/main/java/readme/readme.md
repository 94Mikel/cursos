# Servlets

## Definicion

Los servlets son componentes de software en Java que se ejecutan en un servidor web 
o un servidor de aplicaciones, actuando como intermediarios entre las solicitudes de 
los usuarios (generalmente a través de un navegador web) y las aplicaciones en el servidor. 
Un servlet es una clase Java que implementa la interfaz javax.servlet.Servlet, 
que permite crear dinámicamente contenido web.

- **Interacción con el Cliente y el Servidor**:

Los servlets procesan las solicitudes HTTP de los clientes, interpretan la información, 
ejecutan la lógica del negocio y generan respuestas HTTP que se envían de vuelta al cliente.

- **Portabilidad**:

Dado que los servlets están escritos en Java, son altamente portátiles y 
pueden ejecutarse en cualquier servidor compatible con Java EE que implemente 
el contenedor de servlets.

- **Escalabilidad y Rendimiento**:

Los servlets están diseñados para manejar múltiples solicitudes de manera concurrente, 
compartiendo instancias del servlet entre los hilos de ejecución para maximizar
el rendimiento y la eficiencia.

- **Mantenimiento del Estado**:

Aunque el protocolo HTTP es sin estado, los servlets pueden mantener 
el estado de la interacción del usuario a través de mecanismos como sesiones HTTP, 
cookies y la reescritura de URL.

- **Ciclo de Vida de un Servlet**:

    - **Inicialización**: 
El método init() se llama una vez cuando el servlet es cargado por primera vez en la memoria.
    - **Servicio**: 
El método service() es llamado para cada solicitud del cliente, manejando la lógica principal y respondiendo al cliente.
    - **Destrucción**: 
El método destroy() se llama cuando el servlet es retirado de la memoria, liberando recursos utilizados durante su ejecución.


## Herramientas

### glassfish
GlassFish es un servidor de aplicaciones de código abierto que facilita 
el despliegue de aplicaciones Java EE (Enterprise Edition). 
Desarrollado inicialmente por Sun Microsystems, y ahora mantenido por la Eclipse Foundation, 
GlassFish proporciona un entorno robusto y escalable para la ejecución de aplicaciones 
empresariales.

Caracteristicas:
- **Compatibilidad con Java EE**: 
GlassFish es compatible con la especificación Java EE, lo que permite el desarrollo y 
despliegue de aplicaciones empresariales que utilizan tecnologías como Servlets, 
JavaServer Pages (JSP), Enterprise JavaBeans (EJB), y JAX-RS para servicios web RESTful.

- **Modularidad**: 
Utiliza una arquitectura modular basada en OSGi, lo que permite cargar, descargar, 
iniciar y detener módulos de manera dinámica sin necesidad de reiniciar el servidor.

- **Alta Disponibilidad y Escalabilidad:**
Ofrece capacidades para la alta disponibilidad y escalabilidad, 
incluyendo clustering, balanceo de carga, y replicación de sesiones para asegurar 
la continuidad del servicio y la gestión eficiente de recursos.

- **Facilidad de Administración:** 
Incluye una consola de administración basada en web y herramientas de línea de comandos 
que simplifican la configuración, despliegue y monitoreo de aplicaciones y recursos.

- **Seguridad:** 
Proporciona características avanzadas de seguridad, incluyendo autenticación y autorización, 
cifrado, y soporte para múltiples mecanismos de seguridad.

- **Integración con Herramientas de Desarrollo:** 
Se integra bien con herramientas de desarrollo populares como NetBeans y Eclipse, 
lo que facilita el ciclo de desarrollo, prueba y despliegue de aplicaciones.

GlassFish es utilizado en entornos de producción y desarrollo para alojar 
aplicaciones críticas de negocio debido a su robustez, cumplimiento con estándares 
y soporte continuo de la comunidad.

## Caracteristicas

- Se empaqueta nuestro/s proyecto/s en un archivo .war(Web Archive File).
- La información web esta en la carpeta Web Pages.
- Para definir caracteristicas de web servlest se utilizar el fichero web.xml
