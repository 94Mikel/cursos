/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

/**
 *
 * @author mikel
 */
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//Vamos a agregar la información que queremos compartir con nuestra vista
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j//Para tener acceso de manera automatica la variable log
public class ControladorInicio {

    //Para poder inyectar cualquier dependencia objeto que se administrado por el contenedor anotamos la anotación @Autowired
    //es parecido a Inyect
    @Autowired
    private PersonaService personaService;//hace referencia a la implementación pero se usan los metodos de la clase gracias a spring @Service

    //Por detras se esta ejecutando la tecnologia de los servlets
    //Spring lo esta simplificando todos los procesos
    //Con injeccion de dependencias obtenemos las clases gracias a las annotaciones
    //La fabrica de spring se encarga de instanciar las clases y nosotro los utilizamos directamente. Ejemplo esta clase Model
    @GetMapping("/")
    public String inicio(Model model) {

        var personas = personaService.listarPersonas();

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {//Spring crea la instaciona del objeto Persona
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {//al definir como argumento spring lo inyecta con los datos del formulario
        personaService.guardar(persona);
        return "redirect:/";//para redireccionar a la pagina de inicio
    }

}
