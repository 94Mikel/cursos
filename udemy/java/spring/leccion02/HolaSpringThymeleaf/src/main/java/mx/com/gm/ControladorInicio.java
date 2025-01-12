/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mx.com.gm;

/**
 *
 * @author mikel
 */
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//Vamos a agregar la información que queremos compartir con nuestra vista
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j//Para tener acceso de manera automatica la variable log
public class ControladorInicio {
    
    //Debido a indeccion de dependencias
    //obtenemos la cadeda desde application.properties
    @Value("${index.saludo}")
    private String saludo;
    
    //Por detras se esta ejecutando la tecnologia de los servlets
    //Spring lo esta simplificando todos los procesos
    
    
    //Con injeccion de dependencias obtenemos las clases gracias a las annotaciones
    //La fabrica de spring se encarga de instanciar las clases y nosotro los utilizamos directamente. Ejemplo esta clase Model
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Hola Mundo con Thymeleaf";
        log.info("ejecutando el controlador Spring MVC");
        
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@mail.com");
        persona.setTelefono("22554477");
        
        model.addAttribute("mensaje", mensaje);//Enviar con llave valor
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        
        return "index";
        //el nombre de la pagina que se va a desplegar en el navegador
        //La tecnologia de thymeleaf por default utilizar archivos html en lugar de archivos como JSP
    }
    
}
