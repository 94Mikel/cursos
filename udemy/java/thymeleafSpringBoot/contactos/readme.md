# Pasos a seguir

- No se puede crear una base de datos de postgresl automaticamente con hibernate.
  - Primero hay que crear la base de datos manualmente.
  - Se puede crear automáticamente las tablas mediante hibernate y la clase de entidad. Pero debe existir la base de datos.
- Para realizar el hot reload de los ficheros de la vista, html, css... hay que añadir an el application.propertie lo siguiente:
  - spring.web.resources.static-locations[0]=file:src/main/resources/templates
  - spring.web.resources.static-locations[1]=classpath:/templates/
- 