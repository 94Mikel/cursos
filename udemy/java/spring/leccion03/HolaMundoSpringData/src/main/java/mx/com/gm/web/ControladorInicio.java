/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mx.com.gm.web;

/**
 *
 * @author mikel
 */
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//Vamos a agregar la información que queremos compartir con nuestra vista
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j//Para tener acceso de manera automatica la variable log
public class ControladorInicio {
    
    
    //Por detras se esta ejecutando la tecnologia de los servlets
    //Spring lo esta simplificando todos los procesos
    
    
    //Con injeccion de dependencias obtenemos las clases gracias a las annotaciones
    //La fabrica de spring se encarga de instanciar las clases y nosotro los utilizamos directamente. Ejemplo esta clase Model
    @GetMapping("/")
    public String inicio(Model model){
        log.info("ejecutando el controlador Spring MVC");
//        model.addAttribute("personas", personas);
        return "index";
    }
    
}
