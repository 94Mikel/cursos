package manejoarchivos;

import java.io.*;//input output
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoArchivos {
    
    public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);//en memoria
        try {
            //Para crear el archivo en el disco duro:
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
            /*
            Cuando estemos trabajando con la clase PrintWriter y
            estamos creando un nuevo objeto de esta clase, este constructor
            puede arrojar un excepción.
            */
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
