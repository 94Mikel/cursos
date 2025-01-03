# Java EE: Web Services con JAX-WS en Jakarta EE

Un servicio web (web service) permite a las aplicaciones comunicarse entre sí a través de la red utilizando estándares como SOAP y WSDL. 
JAX-WS es una API en Jakarta EE (antes Java EE) que facilita la creación y consumo de servicios web basados en SOAP. 
A continuación, se detalla cómo crear y consumir servicios web utilizando JAX-WS en Jakarta.

## ¿Qué es JAX-WS?
JAX-WS (Java API for XML Web Services) es una especificación que permite:
- Crear servicios web que exponen métodos de Java como operaciones accesibles por clientes remotos.
- Consumir servicios web desde aplicaciones cliente.
- Generar automáticamente el contrato (WSDL) para definir cómo interactuar con el servicio.

## Características de JAX-WS
- **Basado en SOAP**: JAX-WS usa SOAP (Simple Object Access Protocol), que define un formato XML estandarizado para intercambiar datos.
- **WSDL**: Los servicios web JAX-WS generan automáticamente un contrato WSDL (Web Services Description Language).
- **Interoperabilidad:** Permite que clientes y servicios desarrollados en diferentes plataformas puedan comunicarse.

## Pasos para crear y consumir un servicio web con JAX-WS
1. Configuración del entorno
	- Asegúrate de tener un servidor de aplicaciones Jakarta EE compatible (como Payara, WildFly o GlassFish).
	- Configura un proyecto Maven o Gradle. Ejemplo de pom.xml para Maven
2. Crear la interfaz del servicio (Service Endpoint Interface - SEI)
    
    Define una interfaz con los métodos que estarán disponibles para los clientes. Usa la anotación @WebService para indicarle a JAX-WS que esta interfaz será expuesta como un servicio web.

3. Implementar el servicio

    Implementa la interfaz en una clase concreta y utiliza @WebService para marcar la clase como un servicio web.

4. Publicar el servicio

    Para desplegar el servicio en un servidor Jakarta EE, crea un archivo web.xml (opcional si usas anotaciones) o publícalo programáticamente.

5. Consumir el servicio web

    - Usa herramientas como wsimport (incluido en el JDK) para generar clases Java a partir del WSDL.
    - wsimport -keep -p com.example.client http: localhost:8080/HelloService?wsdl

6. Despliegue en un servidor de aplicaciones
    - Empaqueta tu proyecto como un archivo **.war** o **.ear**.
    - Despliega el archivo en un servidor Jakarta EE como WildFly, GlassFish o Payara.

7. Probar el servicio

    Accede a la URL del servicio desde el navegador para ver el WSDL:

    http://localhost:8080/HelloService?wsdl

    Utiliza herramientas como Postman o clientes SOAP para realizar pruebas adicionales.

# XSD

XSD (XML Schema Definition) es un estándar para definir la estructura, los elementos y las restricciones de los documentos XML. En el contexto de Java, XSD es fundamental para trabajar con datos XML, ya que permite validar, generar, y mapear documentos XML hacia objetos Java y viceversa. Este proceso se conoce como binding.

## Componentes Principales de XSD
- **Estructura**: Define los elementos y atributos permitidos en el XML.
- **Tipos de datos**: Permite especificar restricciones como números, cadenas, fechas, etc.
- **Relaciones**: Define cómo se organizan los elementos (secuencias, opciones, cardinalidad).
- **Validación**: Se asegura de que un archivo XML cumpla con las reglas definidas en el XSD.

## Usos de XSD en Java
- **Validación de XML**: Para verificar que un archivo XML cumpla con las reglas del XSD.
- **Generación de Clases Java desde XSD**: Herramientas como xjc permiten generar clases Java a partir de un archivo XSD.
- **Conversión entre Objetos Java y XML**: Usando bibliotecas como JAXB (Jakarta XML Binding).

## Beneficios de XSD en Java
- **Interoperabilidad**: Define un estándar común para aplicaciones que interactúan con XML.
- **Validación Rápida**: Detecta errores estructurales y semánticos en documentos XML.
- **Automatización**: Facilita la generación de clases Java y la manipulación de datos XML.

## Herramientas Relacionadas
- **JAXB**: Para vincular XML y clases Java.
- **xjc**: Herramienta para generar clases Java desde un XSD.
- **XMLSpy** y **Oxygen**: Herramientas visuales para crear y validar esquemas XSD.

# Ejercicio
- Crear proyecto servicio sumarws para sumar dos numeros en el servior.
	- Desplegamos el proyecto en glassgish y lo probamos.
	- Ejecutar el proyecto para ver si funciona. glassfish =>
	  applications => sumaws => view Endpoint => Tester
	- Obtener la direccion wsdl. Glassfish => applications => sumarws =>
	view endpoint => wsdl(para ponerlo en el pom de clienteSumarWS)
- Crear proyecto cliente ClienteSumarWS con JAX-WS
	- Creamos las clases del servicio mediante WSDL(de xml a clases java) pom => rum Maven =>
	  goals.
	- Creamos la clase ClienteSumaWs para ejecutar cliente.
- Añadir al proyecto sga-jee-web el servicio web.
	- Añadir interface PersonaServiceWs
	- Añadir servicio web a PersonaServiceImpl
- Crear proyecto cliente ClienteSgaWs
	- Creamos las clases del servicio mediante WSDL(de xml a clases java) pom => rum Maven =>
	  goals.
	- Añadir servicio web a ClienteSgaWS

