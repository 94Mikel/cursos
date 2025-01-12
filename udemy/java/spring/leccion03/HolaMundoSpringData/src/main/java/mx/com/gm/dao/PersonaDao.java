package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/*
    @Repository no se utiliza con spring
    
    extendemos de otra interface => CrudRepository
    Cualquier tipo de clase dao vamos a poder crearla utilizando este repositorio
    No tendremos que estar agregando los metodos de insertar, actualizar, eliminar, listar... lo hace CrudRepository
    Hay que indicar el tipo de entidad que tiene que manejar en este caso Persona
    y tambien el tipo primitivo del id de esta clase
    Ya no es necesario crear una implementación
*/

public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
