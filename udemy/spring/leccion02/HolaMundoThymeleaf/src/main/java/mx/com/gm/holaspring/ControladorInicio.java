package mx.com.gm.holaspring;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.holaspring.domain.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Agregara al contenedor de spring. Si no ponemos esta anotacion no se podra usar spring en esta clase
@Controller
@Slf4j
public class ControladorInicio {


    //Para obtener saludo de application.properties
    @Value("${index.saludo}")
    private String saludo;


    //Con model vamos a conparti información con nuestra vista(html)
    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Hola mundo con thymeleaf";

        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@mail.com");
        persona.setTelefono("22558877");

        var persona2 = new Persona();
        persona2.setNombre("Pepe");
        persona2.setApellido("Bilbao");
        persona2.setEmail("pbilbao@mail.com");
        persona2.setTelefono("88774455");

        // List<Persona> personas = new ArrayList<>();
        // personas.add(persona);
        // personas.add(persona2);

        //Tambien se puede hacer asi.
        var personas = Arrays.asList(persona, persona2);
        //var personas = new ArrayList();


        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);//hay que compartir infomacion con key, value
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);

        return "index";
    }

}
