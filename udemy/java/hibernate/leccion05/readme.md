# Ciclo de vida con Hibernate y JPA
El ciclo de vida de una entidad en Hibernate y JPA describe los diferentes estados por los que pasa 
una instancia de una clase de entidad (un objeto) mientras interactúa con el EntityManager o la sesión de Hibernate. 
Comprender este ciclo es fundamental para trabajar correctamente con las entidades, 
garantizar la integridad de los datos y optimizar el rendimiento.

## Estados del ciclo de vida
- Transient (Transitorio)
Una entidad está en el estado "transitorio" cuando:
	- Ha sido creada como un objeto nuevo en memoria, pero no está asociada a ningún contexto de persistencia 
	(como el EntityManager o la sesión de Hibernate).
	- No está gestionada por JPA ni mapeada a ninguna fila de la base de datos.

### Caracteristicas
- No tiene representación en la base de datos.
- No es gestionada ni sincronizada con el contexto de persistencia.
- Puede ser recolectada por el garbage collector si no hay referencias activas.

## Managed(Gestionado o Persistente)
Una entidad entra en el estado "gestionado" cuando está bajo el control del EntityManager o de la sesión de Hibernate. Esto ocurre cuando:
- Se persiste una entidad transitoria utilizando el método persist().
- Se recupera una entidad existente de la base de datos mediante find(), getReference(), o una consulta JPQL.
- Se une una entidad desconectada al contexto de persistencia mediante merge().

### Características:
- Está sincronizada con la base de datos.
- Los cambios realizados en los atributos de la entidad se reflejan automáticamente en la base de datos cuando se realiza un commit o un flush.

## Detached (Desvinculado o Desconectado)
Una entidad pasa al estado "desvinculado" cuando:
- Se cierra el EntityManager o la sesión de Hibernate.
- Se utiliza explícitamente el método detach().
### Caracteristicas:
- No está asociada al contexto de persistencia.
- Los cambios realizados en una entidad desconectada no se sincronizan automáticamente con la base de datos.
- Puede ser reutilizada mediante el método merge() para volver al estado gestionado.

## Removed(Eliminado)
Una entidad entra en el estado "eliminado" cuando:
- Se llama al método remove() del EntityManager o de la sesión de Hibernate.
### Caracteristicas:
- Está marcada para ser eliminada de la base de datos.
- La eliminación se realiza al hacer flush() o commit() de la transacción.
- Permanece en el contexto de persistencia hasta que se finalice la transacción, pero ya no se puede consultar.

## Transacciones entre Estados
- Persist()
	- Estado actual => transitorio
	- Estado resultante => gestionado
- merge()
	- Estado actual => transitorio
	- Estado resultante => gestionado
- detach()
	- Estado actual => gestionado
	- Estado resultante => Desvinculado
- remove()
	- Estado actual => gestionado
	- Estado resultante => Eliminado
- EntityManager.close()
	- Estado actual => gestionado
	- Estado resultante => Desvinculado
- merge()
	- Estado actual => Desvinculado
	- Estado resultante => Gestionado
- EntityManager.close()
	- Estado actual => Eliminado
	- Estado resultante => N/A

## Operaciones Clave
- persist()
	- Mueve una entidad desde el estado Transitorio a Gestionado.
	- Solo afecta a entidades nuevas.
- merge()
	- Mueve una entidad desde el estado Desvinculado o Transitorio a Gestionado.
	- Devuelve una instancia gestionada.
- remove()
	- Marca una entidad como Eliminada.
	- Requiere que la entidad esté en estado Gestionado.
- detach()
	- Desvincula una entidad del contexto de persistencia, pasando al estado Desvinculado.
- flush()
	- Sincroniza el contexto de persistencia con la base de datos, enviando todas las operaciones
	  pendientes.
- close()
	- Cierra el EntityManager, haciendo que todas las entidades gestionadas pasen al estado
	  Desvinculado.

## Diagramas de Ciclo de Vida
Un diagrama típico del ciclo de vida de una entidad podría mostrar estas transiciones de estado, 
con flechas que representan las operaciones como persist(), merge(), detach(), remove() y find().

