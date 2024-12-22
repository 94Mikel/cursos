package test;

import static manejoarchivos.ManejoArchivos.*;

public class TestManejoArchivos {
    public static void main(String[] args) {
        //se puede poner la ruta en el nombre del archivo en cueston para llevarlo a un directorio.
        var nombreArchivo = "prueba.txt";
        //ScrearArchivo(nombreArchivo);
        
        //Agregar información. Estamos sobrescribiendo
        //escribirArchivo(nombreArchivo, "Hola desde Java");
        //escribirArchivo(nombreArchivo, "Mas contenido");
        
        //Anexar información
        //anexarArchivo(nombreArchivo, "Hola desde Java");
        //anexarArchivo(nombreArchivo, "Adios");
        
        leerArchivo(nombreArchivo);
        
    }
}
