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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j//Para tener acceso de manera automatica la variable log
public class ControladorInicio {
    
    //Por detras se esta ejecutando la tecnologia de los servlets
    //Spring lo esta simplificando todos los procesos
    
    @GetMapping("/")
    public String inicio(){
        log.info("ejecutando el controlador Spring MVC");
        return "index";
        //el nombre de la pagina que se va a desplegar en el navegador
        //La tecnologia de thymeleaf por default utilizar archivos html en lugar de archivos como JSP
    }
    
}
