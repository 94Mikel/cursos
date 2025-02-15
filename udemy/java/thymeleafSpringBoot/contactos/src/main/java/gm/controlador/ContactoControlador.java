package gm.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import gm.contactos.modelo.Contacto;
import gm.contactos.servicio.ContactoServicio;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContactoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    private ContactoServicio contactoServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo) {
        List<Contacto> contactos = contactoServicio.listarContactos();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.put("contactos", contactos);//compartimos la información con la capa de presentacion
        return "index";//index.html => redireccionamos a index
    }
    

}
