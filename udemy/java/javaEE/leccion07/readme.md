# API de Criteria en JPA
- Consultas con el API de Criteria en JPA en JakartaEE

## ¿Que es el Criteria API?
El Criteria API es una interfaz que proporciona una forma segura, tipada y flexible de construir consultas SQL mediante programación. 
Este enfoque contrasta con JPQL (Java Persistence Query Language), donde las consultas se escriben como cadenas.

- El api de Criteria es una alternativa al uso de JPQL o SQL Nativo
- Permite la combinación de campos de criterio complejos (ej. Una pantalla de búsqueda avanzada)
- Permite crear queries dinámicos complejos mas facilmente, evitando el concatenado de cadenas.

### Caracteristicas
- Son escritos en código Java
- Son typesafe(parametros revisados en tiempo de compilación)
- Son queries portables(funcionan en cualquier base de datos)
- Se utilizan clases de java en lugar de cadenas JPQL o SQL
- Permite utilizar expresiones, joins, ordenamiento...

### Principales ventajas del Criteria API
- **Consultas dinámicas:** Ideal para construir consultas que varían en tiempo de ejecución.
- **Verificación en tiempo de compilación:** Evita errores comunes de sintaxis en consultas escritas como cadenas.
- **Legibilidad y mantenibilidad:** Organiza las consultas en código Java estructurado.
- **Portabilidad:** Al ser parte de JPA, funciona con múltiples proveedores de persistencia (Hibernate, EclipseLink, etc.).

### Clases y conceptos principales
- **CriteriaBuilder:** Es la clase principal para crear consultas. Proporciona métodos para construir consultas de forma programática.
	- Se obtiene a través de **EntityManager.getCriteriaBuilder().**
- **CriteriaQuery:** Representa la consulta que se está construyendo. Incluye cláusulas como **SELECT, WHERE, GROUP BY, etc.**
- **Root:** Representa la raíz de la consulta, es decir, la entidad principal desde la que se inicia.
- **Predicate:** Representa una condición en la cláusula WHERE. Se utiliza para filtrar resultados.
- **Path:** Representa un atributo de una entidad, usado para referenciar campos específicos.

### Pasos para construir una consulta con Criteria API
1. Obtener el CriteriaBuilder
2. Crear una consulta con CriteriaQuery
3. Definir la raíz de la consulta
4. Construir condiciones (Predicate)
5. Ejecutar la consulta

## Desventajas del Criteria API
- **Verboso:** Puede ser más extenso que JPQL para consultas simples. 
- **Curva de aprendizaje:** Puede resultar complejo para principiantes.
- **Legibilidad:** En consultas muy complejas, puede ser menos legible.

El Criteria API es una herramienta poderosa y flexible que permite construir consultas seguras y dinámicas en Java. 
Si bien puede ser más complejo que JPQL, es ideal para escenarios donde las consultas cambian en tiempo de ejecución.
