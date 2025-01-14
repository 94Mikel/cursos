package mx.com.gm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaSpringApplication.class, args);
	}

}
/*
Parte de las caracteristicas del framework spring es que es un contenedor de classes java
para que spring reconozca las clases que vamos a agrega a nuestra aplicacion deben de estar detro del mismo paquete
donde se encuestra esta clase.Basicamente donde se encuetra la clase con la annotación @SpringBootApplication.
Ya que dentro de la annotacion SpringBootApplication tenemos la anotación de @ComponentScan. Esto quiere decir que esta annotación 
va a encontrar estas clases que se encuentran dentro de este mismo paquete. Si tenemos una clase fuera de este paquete no la va a 
reconocer.

*/