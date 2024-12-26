# Java EE: Asociaciones y persistencia en cascada en JPA

## Asociaciones => Fetch lazy e Eager
- Lazy
	- Las entidades relacionadas no se cargan de inmediato junco con la entidad principal. 
	En lugar de eso, se cargan solo cuando se acceden explícitamente.
	- Ventajas
		- Mejor rendimiento si no necesitas acceder siempre a las entidades relacionadas.
		- Reduce el uso de memoria y carga inicial de datos innecesarios.
	- Ejemplo
		- @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)

- Eager
	- Las entidades relacionadas se cargan automáticamente junto con la entidad principal en la misma consulta.
	- Ventajas
		- Conveniente si necesitas las entidades relacionadas inmediatamente.
		- Evita problemas de inicialización perezosa fuera del contexto de persistencia.
	- Ejemplo
		- @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	- Desventajas
		- Puede cargar datos innecesarios, lo que aumenta el tiempo de respuesta y el uso de
		memoria.
		- Si las relaciones tienen muchas entidades (como listas largas), puede resultar en
		consultas costosas o problemas de rendimiento.

## Persistencia en cascada JPA
La persistencia en cascada en JPA (Java Persistence API) es una funcionalidad que permite aplicar automáticamente operaciones de persistencia 
(como guardar, actualizar, eliminar, etc.) en una entidad asociada, a las entidades relacionadas con ella. 
Esto facilita la gestión de relaciones entre entidades al evitar la necesidad de manejar explícitamente cada entidad asociada.

### Concepto de cascada
Cuando una entidad principal realiza una operación (como persist o remove), JPA propagará esta operación a las entidades relacionadas 
si se configura la persistencia en cascada. Esto es útil en relaciones como @OneToMany, @ManyToOne, @OneToOne, y @ManyToMany.
Por ejemplo, si guardas un objeto Padre, y tiene hijos relacionados, estos hijos también se guardarán automáticamente 
si la persistencia en cascada está habilitada.

### Tipos de Operaciones en cascada
JPA define varios tipos de operaciones de cascada, las cuales se configuran mediante la anotación cascade en la relación. 
Los valores más comunes son:
- CascadeType.PERSIST
	- Propaga la operación de persistencia (EntityManager.persist()) de la entidad principal a las entidades relacionadas.

- CascadeType.MERGE
	- Propaga la operación de fusión (EntityManager.merge()) de la entidad principal a las entidades relacionadas.

- CascadeType.REMOVE
    - Propaga la operación de eliminación (EntityManager.remove()) de la entidad principal a las entidades relacionadas.

- CascadeType.REFRESH
    - Propaga la operación de refresco (EntityManager.refresh()) de la entidad principal a las entidades relacionadas.

- CascadeType.DETACH
    - Propaga la operación de desapego (EntityManager.detach()) de la entidad principal a las entidades relacionadas, eliminándolas del contexto de persistencia.

- CascadeType.ALL
    - Propaga todas las operaciones anteriores: PERSIST, MERGE, REMOVE, REFRESH, y DETACH.

### Ventajas
- Simplifica el código al no tener que manejar cada entidad relacionada explícitamente.
- Facilita el manejo de relaciones complejas entre entidades.
- Reduce errores asociados con operaciones manuales.