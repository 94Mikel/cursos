# Manejo de transacciones con Spring

El manejo de transacciones en Spring es un aspecto clave para garantizar la integridad 
y la consistencia de los datos en aplicaciones empresariales. 
A continuación, se describe detalladamente cómo funciona el manejo de transacciones en Spring:

## ¿Qué es una transacción?
Una transacción es una unidad de trabajo que debe completarse de manera completa o no completarse en absoluto. 
Las transacciones siguen las propiedades ACID:
- **Atomicidad**: Todas las operaciones dentro de la transacción se completan, o ninguna lo hace.
- **Consistencia**: El sistema debe pasar de un estado consistente a otro.
- **Aislamiento**: Las transacciones concurrentes no interfieren entre sí.
- **Durabilidad**: Los cambios realizados por una transacción confirmada se guardan permanentemente.

## Manejo de transacciones en Spring
Spring Framework proporciona un soporte robusto para la gestión de transacciones a través del módulo Spring Transaction Management. 
Hay dos formas principales de manejar transacciones en Spring:
- **Programática**: El desarrollador controla explícitamente el inicio, compromiso y reversión de la transacción en el código.
- **Declarativa**: Las transacciones se configuran mediante anotaciones o configuraciones XML, 
lo que abstrae los detalles técnicos del manejo de transacciones.

###  Manejo programático
En el manejo programático, se utiliza la clase **TransactionTemplate** o directamente las interfaces del API de transacciones de Spring. 
Este enfoque da control granular sobre las transacciones pero puede hacer que el código sea más complejo.

### Manejo declarativo
La gestión declarativa de transacciones utiliza anotaciones o configuraciones. 
Es el enfoque más común porque simplifica el código y separa las preocupaciones de la lógica de negocio y la gestión de transacciones.

**Configuración con anotaciones**
- **Habilitar la gestión de transacciones**: Añade la anotación @EnableTransactionManagement en una clase de configuración.
- **Anotar métodos o clases con @Transactional:**
	- Al aplicar **@Transactional** en un método, Spring inicia una transacción antes de que el método se ejecute 
	y la cierra (compromiso o reversión) al final.

## Configuración en Spring
- **Dependencias necesarias**: Agrega la dependencia del módulo Spring JDBC o Spring Data JPA según el
  caso.
- **Configurar un gestor de transacciones (PlatformTransactionManager)**: Para habilitar las transacciones, Spring necesita un gestor de transacciones. 
Este gestor varía según la tecnología de persistencia (JPA, JDBC, Hibernate, etc.).

## Control avanzado de transacciones
La anotación **@Transactional** permite configurar diversos aspectos de una transacción:
- **Propagación (propagation)**: Define cómo debe comportarse la transacción en relación con las transacciones existentes:
	- **REQUIRED (por defecto)**: Usa una transacción existente o crea una nueva.
	- **REQUIRES_NEW**: Siempre crea una nueva transacción, suspendiendo la existente.
	- **NESTED**: Crea una transacción anidada dentro de una existente.
	- Otros valores: **MANDATORY, SUPPORTS, NOT_SUPPORTED, NEVER.**
- **Aislamiento (isolation)**: Controla el nivel de aislamiento de la transacción (READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE, etc.).
- **Rollback (rollbackFor y noRollbackFor)**: Especifica qué excepciones deben causar una reversión o no.

## Ventajas del manejo transaccional en Spring
- **Simplificación:** Reduce el código boilerplate con el manejo declarativo.
- **Flexibilidad:** Ofrece configuraciones avanzadas para escenarios complejos.
- **Integración:** Funciona con varias tecnologías (JPA, Hibernate, JDBC, etc.).

## Errores comunes al manejar transacciones
- **Anotar métodos privados: @Transactional** no funciona en métodos privados porque Spring usa proxies para manejar las transacciones.
- **Llamadas internas:** Si un método anotado con **@Transactional** llama a otro método dentro de la misma clase, 
las transacciones no se aplican correctamente.
- **Falta de un gestor de transacciones:** Si no se configura correctamente un PlatformTransactionManager, las transacciones no funcionarán.

