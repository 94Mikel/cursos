package gm.inventarios.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Vamos a utilizar en una respuesta de tipo rest
 * Agregamos a anotacion de ResponseStatus
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND) // Recurso no encontrado.
public class RecursoNoEncontradoExcepcion extends RuntimeException {
    public RecursoNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
