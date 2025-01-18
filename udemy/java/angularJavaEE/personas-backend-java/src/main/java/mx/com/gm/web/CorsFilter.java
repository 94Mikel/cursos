package mx.com.gm.web;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider//Parte de la implementación del filtro cors
public class CorsFilter implements ContainerResponseFilter {

    //Filtro para superar la politica de CORS
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        //Definimos la politica de CorsFilter
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        //Agregamos los siguientes cabeceros

        //Abrimos todas las peticines puedan entrar a nuestro webService
        // Se podria filtrar la entrada de tipo de peticiones a nuestro webService. 
        headers.add("Access-Control-Allow-Origin", "*");

        //Permitir el uso de credenciales
        headers.add("Access-Control-Allow-Credentials", "true");

        //Para especificar los cabeceros permitidos
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");

        //Los metodos que vamos a permitir que se ejecuten sobre nuestro servicio web
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

    }

}
