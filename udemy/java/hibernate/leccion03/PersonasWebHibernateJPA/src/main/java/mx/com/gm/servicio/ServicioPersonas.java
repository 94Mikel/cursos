package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class ServicioPersonas {
    
    private PersonaDAO personaDao;
    
    public ServicioPersonas(){
        //creamos el objeto personaDao para utilizarlo. Obtener información de la bd...
        this.personaDao = new PersonaDAO();
    }
    
    public List<Persona> listarPersonas(){
        return this.personaDao.listar();
    }
    
}
