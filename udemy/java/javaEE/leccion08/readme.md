# Transacciones con JakartaEE

- El proyecto hay que ejecutar con JDK 11. Properties => compile => jdk 11

## ¿Que es una transacción?
Una transacción es un conjunto de operaciones que se ejecutan como una unidad atómica, es decir, 
todas deben completarse correctamente o ninguna se aplicará. Las transacciones aseguran las propiedades ACID:
1. **Atomic (Atomicidad):** Todas las operaciones se completan o ninguna lo hace. Las actividades de un metodo se consideran como una unidad de trabajo.
2. **Consistent (Consistencia):** La base de datos pasa de un estado válido a otro. Una vez que termina una transacción la información queda en estado consistente, ya que se realiza todo o nada.
3. **Isolated (Aislamiento):** Las operaciones de una transacción no interfieren con otras. Multiples usuarios pueden utilizar los métodos transaccionales, sin embargo debemos prevenir errores por accesos múltiples, aislando en la medida de lo posible nuestros métodos transaccionales. Normalmente involucra en bloqueo de registros o tablas de base de datos(bloqueo).
4. **Durable (Durabilidad):** Los cambios realizados en una transacción exitosa son permanentes. Sin importar si hay una caída del servidor, una transacción exitosa debe guardarse y perdurar posterior al termino de una transacción.

## Componentes clave de una transacción
1. **Inicio:** La transacción comienza explícitamente (manual) o automáticamente (en algunos frameworks).
2. **Commit:** Si todas las operaciones se completan correctamente, se confirman los cambios.
3. **Rollback:** Si ocurre un error, se deshacen todos los cambios realizados en la transacción.

## Tipos de Transacciones en Java
1. Transacciones locales
	- Manejan una única conexión de base de datos.
	- Se usan principalmente con un **EntityManager** o **JDBC**.
2. Transacciones globales:
	- Manejan múltiples recursos como bases de datos, colas de mensajes, etc.
	- Requieren un gestor de transacciones, como **JTA (Java Transaction API).**

## Gestión de transacciones con JPA
### Configuración de una transacción básica
El objeto **EntityManager** se utiliza para manejar transacciones en JPA. Una transacción típica incluye:
1. Iniciar la transacción con begin()
2. Realizar operaciones en la base de datos
3. Confirmar (commit) o deshacer (rollback) la transacción.

## Configuración de propagación en Java EE
Demarcación de transacciones por medio de Container-Managed Transactions (CMTs)

Tipo de programación y significado:
- **MANDATORY**: El metodo tiene que ejecutarse dentro de una transacción, de lo contrario se lanzará una excepción.
- **REQUIRED**: El método DEBE ejecutarse dentro de una transacción. Si ya existe una transacción el método la utilizará, de lo contrario creará una nueva.
- **REQUIRES_NEW**: El método DEBE ejecutarse dentro de una trasacción. Si ya existe una trasacción, se suspende durante la ejecución del método, de lo contrario creará una nueva.
- **SUPPORTS**: Indica que el método no requiere el manejo transaccional, pero puede participar de una transacción si ya hay alguna ejecutándose.
- **NOT_SUPPORTED**: El método NO debe ejecutarse en una transacción. Si ya existe una transacción, se suspenderá hasta la conclusión del método.
- **NEVER**: El método NO debe ejecutarse en una transacción, de lo contrario lanza una excepción.

