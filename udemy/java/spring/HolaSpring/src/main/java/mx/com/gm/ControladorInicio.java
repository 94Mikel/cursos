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
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j//Para tener acceso de manera automatica la variable log
public class ControladorInicio {
    
    @GetMapping("/")
    public String inicio(){
        log.info("ejecutando el controlador rest");
        log.debug("mas detalle del controlador");
        return "HolaMundo con Spring Boot";
    }
    
}
