package beans;

import org.apache.logging.log4j.*;
import org.apache.struts2.ActionSupport;

/*
Una clase action de struts no necesariamente debe implementar o extender una clase de java.
Esta es una de las diferencias con la version 1 de struts, así que en este caso únicamente 
vamos a agregar los siguiente para crear clase de tipo action.

Lo unico que tiene que tener nuestra clase de tipo action es la implementación de un metodo llamado execute.

*/

public class HolaMundoAction extends ActionSupport{
    
    Logger log = LogManager.getLogger(HolaMundoAction.class);
    
    /*
        Definimos un atributo que es el que vamos a utilizar desde el JSP para poder 
        mandar información hacia el cliente.
    */
    
    private String saludosAtr;
    
    @Override
    public String execute(){
        log.info("ejecutando metodo execute desde struts2");
        this.saludosAtr = "Saludos desde Struts2";
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
    
}
