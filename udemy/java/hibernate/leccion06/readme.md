# Persistencia en cascada en Hibernate y JPA

La persistencia en cascada en Hibernate y JPA es una característica que permite propagar automáticamente 
operaciones realizadas en una entidad hacia las entidades relacionadas. 
Esto simplifica la gestión de entidades dependientes o asociadas, 
ya que no es necesario operar manualmente sobre cada entidad relacionada.

## ¿Qué es la persistencia en cascada?
Cuando dos entidades tienen una relación (por ejemplo, Empleado y Departamento), 
la persistencia en cascada permite que ciertas acciones realizadas en la entidad principal (como persistir, actualizar, eliminar, etc.) 
se propaguen automáticamente a las entidades relacionadas.

La persistencia en cascada se configura a través del atributo cascade de las anotaciones de 
mapeo de relaciones como @OneToOne, @OneToMany, @ManyToOne y @ManyToMany.

## Tipos de Cascade
Hibernate y JPA ofrecen diferentes tipos de propagación de operaciones a través del atributo CascadeType. Los más comunes son:
- CascadeType.PERSIST
	- Propaga la operación persist() a las entidades relacionadas.
	- Si la entidad principal se persiste, todas las entidades relacionadas también se persistirán automáticamente.
- CascadeType.MERGE
	- Propaga la operación merge() a las entidades relacionadas.
	- Si la entidad principal se actualiza, las entidades relacionadas también se sincronizan con el contexto de persistencia.
- CascadeType.REMOVE
	- Propaga la operación remove() a las entidades relacionadas.
	- Si la entidad principal se elimina, las entidades relacionadas también serán eliminadas.
- CascadeType.REFRESH
	- Propaga la operación refresh() a las entidades relacionadas.
	- Restaura el estado de las entidades relacionadas desde la base de datos, descartando cualquier cambio no guardado.
- CascadeType.DETACH
	- Propaga la operación detach() a las entidades relacionadas.
	- Desvincula las entidades relacionadas del contexto de persistencia.
- CascadeType.ALL
	- Combina todas las opciones anteriores (PERSIST, MERGE, REMOVE, REFRESH y DETACH).

## Ejemplos Prácticos
- Persistencia en Cascada (CascadeType.PERSIST)
Si un Departamento tiene una lista de Empleado y queremos que al persistir un Departamento, también se persistan automáticamente sus
  Empleado.

- Eliminación en Cascada (CascadeType.REMOVE)
Si queremos que al eliminar un Departamento, también se eliminen automáticamente sus
  Empleado.

- Cascada Combinada (CascadeType.ALL)
Si queremos que todas las operaciones (persistencia, actualización, eliminación, etc.) se propaguen, usamos CascadeType.ALL

## Consideraciones Importantes
- Relaciones bidireccionales:
	- En relaciones bidireccionales, el cascade se configura generalmente en el lado propietario de la relación.
- Evitar eliminaciones no intencionales:
	- Si usas CascadeType.REMOVE, ten cuidado de no eliminar accidentalmente entidades relacionadas que no deberían ser eliminadas.
- Cascade y FetchType:
	- La configuración de cascade es independiente de la estrategia de carga (FetchType.LAZY o FetchType.EAGER).
- Cascada y transacciones:
	- Las operaciones en cascada se ejecutan dentro de la misma transacción que la operación principal.
- Uso adecuado:
	- No siempre es necesario aplicar CascadeType.ALL. Elige los tipos de cascada específicos que necesites 
	para evitar comportamientos inesperados.

## Errores Comunes
- TransientObjectException:
	- Si intentas persistir una entidad que tiene una relación con una entidad transitoria y no usas CascadeType.PERSIST, obtendrás este error.
- Eliminaciones no deseadas:
	- Configurar CascadeType.REMOVE en relaciones donde las entidades relacionadas no deben eliminarse puede causar pérdida de datos.
- Propagación incorrecta:
	- Usar CascadeType.ALL sin entender completamente el impacto puede llevar a actualizaciones o eliminaciones no deseadas.
