package mx.com.gm.holaspring;

import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

//Agregara al contenedor de spring. Si no ponemos esta anotacion no se podra usar spring en esta clase
@RestController
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    public String inicio() {
        log.info("ejecutando el controlador rest");
        log.debug("mas detalles del controlador");
        return "HolaMundo con Spring 2";
    }

}
