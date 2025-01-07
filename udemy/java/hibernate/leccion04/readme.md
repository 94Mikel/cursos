# Asociaciones con Hibernate

Las asociaciones en Hibernate, un marco de mapeo objeto-relacional (ORM) para Java, 
son una forma de modelar las relaciones entre entidades de una base de datos en el nivel del código. 
Estas asociaciones permiten que las entidades estén conectadas entre sí de manera que refleje las relaciones definidas en el esquema relacional, 
como las claves primarias y foráneas.

A continuación, te explico detalladamente los tipos de asociaciones y cómo se configuran:

## Tipos de asociaciones en Hibernate
- One-to-One (Uno a Uno)
	- Representa una relación donde una fila de una tabla está relacionada con una única fila de otra tabla.
	- Ejemplo => Una persona tiene un pasaporte.

- One-to-Many (Uno a Muchos)
	- Una entidad está relacionada con múltiples instancias de otra entidad.
	- Ejemplo => Un departamento tiene varios empleados.

- Many-to-One (Muchos a Uno)
	- La relación inversa de One-to-Many: muchas instancias de una entidad están relacionadas con una sola instancia de otra entidad.
	- Ejemplo => Muchos pedidos pertenecen a un cliente.

- Many-to-Many (Muchos a Muchos)
	- Representa una relación donde varias instancias de una entidad están relacionadas con varias instancias de otra entidad.
	- Ejemplo => Un estudiante puede inscribirse en varios cursos, y un curso puede tener varios estudiantes.

## Mapeo unidireccional vs bidireccional
- **Unidireccional**: Una entidad conoce la relación, pero la otra no.
	- Ejemplo: Solo el Estudiante conoce los Cursos.
- **Bidireccional**: Ambas entidades conocen la relación.
	- Ejemplo: Tanto el Estudiante como el Curso conocen su relación.

La bidireccionalidad se logra utilizando la propiedad **mappedBy** para indicar cuál lado es el propietario de la relación.

## Propiedades clave en las asociaciones
- **@JoinColumn**: Especifica la columna que actúa como clave foránea.
- **cascade**: Define las operaciones en cascada (e.g., CascadeType.ALL propaga las operaciones persist, merge, remove, etc.).
- **fetch**: Controla cómo se cargan los datos relacionados:
	- **FetchType.LAZY** (predeterminado en relaciones OneToMany y ManyToMany): Los datos se cargan solo cuando se accede a ellos.
	- **FetchType.EAGER** (predeterminado en relaciones ManyToOne y OneToOne): Los datos se cargan de inmediato.

## Consideraciones y mejores prácticas
- **Elegir el tipo de asociación adecuado**: Evalúa cuidadosamente las relaciones de la base de datos antes de modelarlas.
- Usar **FetchType.LAZY** donde sea posible: Mejora el rendimiento al evitar cargas innecesarias.
- **Cuidado con las referencias circulares**: En relaciones bidireccionales, maneja las serializaciones con cuidado para evitar bucles infinitos.
- **Optimizar el diseño**: No abuses de las relaciones bidireccionales si no son necesarias.
- **Configurar correctamente el cascade**: Esto puede evitar errores relacionados con la persistencia de datos.

