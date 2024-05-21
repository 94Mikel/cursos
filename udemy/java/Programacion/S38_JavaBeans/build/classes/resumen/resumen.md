# Seccion 38 Java Beans
- Para que una clase en java se considere javaBean debe de cumplir ciertas caracteristicas.
    - Debe terner constructor vacio.
    - Cada atributo de la clase tiene que ser privado.
    - Cada atributo privado debe tener metodos get y set.
    - Debe implementar una interface llamada Serializable

- Serializable: 
    - Permiter enviar nuestra clase entre diferentes equipos.
    - Si tenemos diferentes servidores de java y necesitamos transferir esta clase java
entre diferentes equipos.
    - Serialización => Convertir nuestro objeto a ceros y unos(a bits)
    - Deserialización => ceros y unos(bits) convertir a clase.