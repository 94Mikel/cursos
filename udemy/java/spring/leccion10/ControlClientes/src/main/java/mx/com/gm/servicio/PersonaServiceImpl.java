package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//Para que Spring sepa que es una clase de servicio
public class PersonaServiceImpl implements PersonaService {
    
    @Autowired//para obtener la instacia de personaDao
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)//para realizar el commit o el rollback de la operación. Solo vamos a leer información de la base de datos
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        //si no encuentra el objeto a buscar retornara null
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
