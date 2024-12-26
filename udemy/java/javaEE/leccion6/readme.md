# Consultas con JPQL (Java Persistence Query Language)
## Definicion
Java Persistence Query Language (JPQL) es un lenguaje de consulta orientado a objetos diseñado para interactuar 
con bases de datos en aplicaciones Java que usan Java Persistence API (JPA). 
JPQL se utiliza para escribir consultas que operan sobre entidades persistentes y sus relaciones, 
en lugar de hacerlo directamente sobre las tablas y columnas de la base de datos.

A continuación, se detalla cómo funciona JPQL, sus características principales y algunos
ejemplos:

### Características principales de JPQL
- **Orientado a objetos:** Las consultas están escritas en términos de clases de entidad, propiedades y relaciones, en lugar de tablas y columnas.
- **Abstracción del esquema:** JPQL abstrae la lógica de acceso a datos para que sea independiente del proveedor de la base de datos.
- **Basado en SQL:** Aunque se parece a SQL, tiene su propio conjunto de reglas y sintaxis adaptadas al modelo de entidades de JPA.
- **Compatibilidad con relaciones:** Soporta navegaciones a través de relaciones entre entidades (e.g., @OneToMany, @ManyToOne).

### Componentes de JPQL
- Sentencias principales
	- **SELECT:** Para recuperar datos.
	- **UPDATE:** Para actualizar datos.
	- **DELETE:** Para eliminar datos.
- Cláusulas comunes
	- **FROM:** Indica la entidad base.
    	- **WHERE:** Filtra resultados con condiciones.
	- **GROUP BY y HAVING:** Agrupa y filtra resultados agrupados.
    	- **ORDER BY:** Ordena los resultados.
- Funciones y expresiones
JPQL incluye funciones similares a SQL para manipular cadenas, números, fechas, etc. Por ejemplo:
	- **Funciones agregadas:** COUNT, SUM, AVG, MAX, MIN.
	- **Funciones de cadenas:** CONCAT, SUBSTRING, UPPER, LOWER.
	- **Funciones de fechas:** CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP.
### Sintaxis básica de JPQL
- SELECT
	- SELECT e FROM Employee e WHERE e.salary > 50000
	- Recupera objetos de tipo Employee cuyo salario sea mayor a 50,000.
	- Employee es el nombre de la clase de entidad, no el nombre de la tabla.
- JOIN para relaciones
	- SELECT p FROM Project p JOIN p.employees e WHERE e.name = 'John Doe'
	- Realiza un JOIN entre entidades relacionadas. Aquí, un proyecto (Project) está relacionado con empleados (Employee) mediante una colección employees.
- Agregados y agrupación
	- SELECT d.name, COUNT(e) FROM Department d JOIN d.employees e GROUP BY d.name HAVING COUNT(e) > 5
	- Cuenta cuántos empleados hay por departamento, pero solo muestra aquellos con más de 5 empleados.
- Ordenación
	- SELECT e FROM Employee e ORDER BY e.salary DESC
	- Recupera empleados ordenados por salario en orden descendente.
- Parámetros
JPQL admite parámetros para evitar inyecciones SQL y reutilizar consultas:
	- SELECT e FROM Employee e WHERE e.name = :name
	- Aquí, :name es un parámetro que se debe establecer en tiempo de ejecución.
### Operaciones avanzadas
- subconsultas
	- SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)
	- Recupera empleados cuyo salario sea superior al promedio.
- Herencia
Si las entidades están organizadas en una jerarquía con herencia:
	- SELECT c FROM Contractor c WHERE c.rate > 50
	- Consulta únicamente objetos del subtipo Contractor.
- Funciones de proyección
En lugar de obtener entidades completas, se pueden seleccionar campos específicos:
	- SELECT e.name, e.salary FROM Employee e
	- Devuelve nombres y salarios en lugar de objetos Employee.
- Ejemplo completo
	- SELECT e.name, e.salary, d.name FROM Employee e JOIN e.department d WHERE e.salary > 60000
	- Recupera los nombres de empleados, sus salarios y los nombres de sus departamentos para aquellos con salarios superiores a 60,000.

JPQL es esencial para desarrollar aplicaciones empresariales que manejan datos complejos con JPA, 
ofreciendo una manera elegante y abstracta de interactuar con bases de datos.

