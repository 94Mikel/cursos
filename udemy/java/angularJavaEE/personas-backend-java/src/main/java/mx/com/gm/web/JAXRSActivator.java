package mx.com.gm.web;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/*
Para activar nuestro servicio web JAX-RS
*/

@ApplicationPath("webservice")//El nombre del path que vamos a utilizar para acceder a nuetro servicio web
public class JAXRSActivator extends Application {//Extendemos para acceder a nuestro servicio web jax-rs
    
}
