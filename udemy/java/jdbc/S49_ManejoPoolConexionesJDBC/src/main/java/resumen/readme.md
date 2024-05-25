# Patrones de diseño

## Capa de presentación

La capa de presentación es una de las capas del modelo de arquitectura de software 
que se encarga de la presentación de la información al usuario final. 
Es la capa más cercana al usuario y se encarga de interactuar con la interfaz de usuario, 
mostrando información de manera clara y comprensible. 
Su función principal es la de gestionar la presentación de la información de manera adecuada y 
asegurar una buena experiencia de usuario. 

En resumen, la capa de presentación se encarga de la representación visual de la información 
que se muestra al usuario.

- MVC

La capa de presentación en el patrón MVC (Modelo-Vista-Controlador) es la parte encargada de mostrar 
la información al usuario y de capturar las interacciones que este usuario tenga con la aplicación. 
Esta capa se encarga de mostrar los datos que provienen del modelo de la aplicación de una manera 
visualmente atractiva y de gestionar las interacciones del usuario a través de la vista.

- Front controller

La capa de presentación Front Controller es un patrón de diseño de software que centraliza el 
manejo de las solicitudes de un sistema o aplicación web. 
En este patrón, un controlador único (Front Controller) se encarga de recibir todas las solicitudes del usuario, 
procesarlas y dirigirlas a los controladores específicos correspondientes para su procesamiento adicional.

El Front Controller actúa como un punto de entrada principal para la aplicación y 
maneja tareas comunes de forma centralizada, como la autenticación, la autorización, la gestión de sesiones, 
la validación de formularios, entre otros. Esto permite una mejor modularidad y mantenibilidad del sistema, 
ya que la lógica de presentación se centraliza en un solo lugar.

En resumen, la capa de presentación Front Controller es un componente clave en la arquitectura de una aplicación 
web que facilita la gestión y el control de las solicitudes de usuario de manera centralizada.

- DTO

DTO (Data Transfer Object) es un patrón de diseño que se utiliza en el desarrollo de software para representar 
un objeto que transporta datos entre diferentes capas de una aplicación. 
En el contexto de una capa de presentación, un DTO es un objeto que se utiliza para transferir datos entre la capa de presentación 
y la capa de negocio o de persistencia de datos.

La capa de presentación DTO se encarga de transformar los objetos de dominio de la aplicación en objetos simples que contienen 
solo los datos necesarios para la interfaz de usuario. 
Esto ayuda a reducir la complejidad de los objetos que se envían a través de la red y mejora la eficiencia de la comunicación 
entre las diferentes capas de la aplicación.

En resumen, la capa de presentación DTO se utiliza para transferir datos de manera eficiente entre la capa de presentación y 
otras capas de la aplicación, manteniendo la separación de responsabilidades y facilitando la comunicación 
entre los diferentes componentes del sistema.

## Capa de negocio o servicio

La capa de negocio es una parte de la arquitectura de software que se encarga de contener 
la lógica empresarial de una aplicación. 
Esta capa se sitúa entre la capa de presentación (interfaz de usuario) y 
la capa de acceso a datos (base de datos) y se encarga de procesar la información, 
tomar decisiones empresariales y gestionar la lógica del negocio de la organización.

En resumen, la capa de negocio se encarga de todas las operaciones y 
reglas de negocio de la aplicación, estableciendo la forma en que los datos son tratados y 
manipulados dentro del sistema. 
Esto permite separar las responsabilidades y facilita la escalabilidad y mantenimiento del sistema.

- Business delegate

La capa de servicio business delegate es un patrón de diseño que se utiliza en arquitecturas de software para separar 
la lógica de negocio de la lógica de presentación. Funciona como un intermediario entre la capa de presentación 
y la capa de servicios, encapsulando la interacción con los servicios y proporcionando una interfaz fácil de usar para la capa de presentación. 
Ayuda a reducir la dependencia entre las capas de la aplicación y facilita la reutilización y el mantenimiento del código.

- Service locator

La capa de servicio service locator es un patrón de diseño que se utiliza en el desarrollo de software para centralizar la localización 
y obtención de servicios en una aplicación. 
En lugar de que los componentes de la aplicación dependan directamente de la implementación de los servicios, 
se utiliza un componente central llamado service locator que actúa como un registro de servicios, 
permitiendo que los componentes soliciten los servicios que necesiten a través de un intermediario.

El service locator se encarga de crear, mantener y gestionar la instancia de los servicios, 
así como de manejar las dependencias entre los diferentes servicios. 
De esta manera, los componentes de la aplicación pueden acceder a los servicios necesarios sin necesidad de conocer su implementación concreta, 
lo que facilita la modificación y reutilización de los servicios en diferentes partes de la aplicación.

En resumen, la capa de servicio service locator permite centralizar la gestión y acceso a los servicios de una aplicación, 
lo que facilita la modularidad y la mantenibilidad del software.

- DTO

Una capa de servicio DTO se refiere a una capa de la arquitectura de software que se encarga de manejar los objetos de 
transferencia de datos (DTO) entre la capa de presentación y la capa de negocio. 
Estos objetos son utilizados para transferir datos entre diferentes componentes del sistema de manera eficiente y sin exponer la lógica de negocio.

En esta capa, se realiza la conversión de los objetos de dominio a objetos DTO y viceversa, 
permitiendo así separar las responsabilidades y mejorar la mantenibilidad y escalabilidad del sistema. 
Además, la capa de servicio DTO también se encarga de realizar validaciones y 
transformaciones de los datos antes de ser transferidos entre las distintas capas del sistema.

## Capa de acceso a datos

La capa de acceso a datos es una capa de software que se encarga de manejar la comunicación 
entre la capa de negocios o lógica de la aplicación y la capa de almacenamiento de datos. 

Su principal función es interactuar con la base de datos y realizar operaciones de lectura, 
escritura, actualización y eliminación de datos. 

Esta capa también se encarga de transformar los datos entre el formato utilizado 
por la aplicación y el formato utilizado por la base de datos, 
facilitando la interacción entre ambas capas.

- DAO

La capa de acceso a datos (DAO, por sus siglas en inglés Data Access Object) es un patrón de diseño que 
se utiliza en programación para separar la lógica de acceso a la base de datos de la lógica de negocio de una aplicación. 
El DAO actúa como una interfaz entre la capa de lógica de negocio y la base de datos, 
permitiendo que la lógica de negocio se comunique de manera independiente con la base de datos.

En resumen, la capa DAO se encarga de realizar operaciones de lectura, escritura, actualización y 
eliminación de datos en la base de datos de la aplicación, abstrayendo la complejidad de dichas operaciones y 
permitiendo que la lógica de negocio se mantenga modular y desacoplada de la base de datos en sí.

- DTO

La capa de acceso a datos DTO (Data Transfer Object) es una capa de la arquitectura de software que se utiliza 
para transferir datos entre el código de negocio y la capa de persistencia de datos de un sistema. 
Los DTO son objetos simples que contienen datos que se van a transferir entre las diferentes capas de la aplicación, 
sin contener lógica de negocio ni métodos complejos.

Los DTO se utilizan para facilitar la comunicación entre las diferentes capas de la aplicación, 
permitiendo que los datos se puedan encapsular y transferir de manera eficiente y segura. 
Esta capa también ayuda a separar la lógica de negocio de la capa de persistencia, lo que facilita la modularidad y el mantenimiento del código.

En resumen, la capa de acceso a datos DTO es una capa de la arquitectura de software que se utiliza para transferir datos 
entre las diferentes capas de una aplicación de forma eficiente y segura, sin incluir lógica de negocio ni métodos complejos.
