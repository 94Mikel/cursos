/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

/**
 *
 * @author mikel
 */
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//Vamos a agregar la información que queremos compartir con nuestra vista
import org.springframework.validation.Errors;
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
    //@AutenticationPrincipal => para saber que usuario a echo login
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login: "+user);
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {//Spring crea la instaciona del objeto Persona
        return "modificar";
    }

    //al definir como argumento spring lo inyecta con los datos del formulario
    //@Valid => para indicar que este tipo de objeto persona se va a validar
    //Errors => Si tenos errores en el formulario
    // @Valid Persona y errors => los argumentos uno detras de otro
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if(errores.hasErrors()){//Preguntamos si tenemos errores
            return "modificar";
        }
        
        personaService.guardar(persona);
        return "redirect:/";//para redireccionar a la pagina de inicio
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {//Spring crea la instacia de persona con el idPersona que recibimos
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")//Spring crea la instacia de persona con el idPersona que recibimos desde query parameter
    public String eliminar(Persona persona) {
        persona = personaService.encontrarPersona(persona);
        personaService.eliminar(persona);
        return "redirect:/";//para redireccionar a la pagina de inicio
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";//Nombre de la plantilla de Thymeleaf (login.html)
    }
    
    @GetMapping("/errores/403")
    public String accessDenied(){
        return "errores/403";//Nombre de la plantilla de Thymeleaf (403.html)
    }

}
