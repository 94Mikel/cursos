package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    public AccesoDatosImpl() {
    }

    @Override
    public Boolean exist(String nombreArchivo) {
        File f = new File(nombreArchivo);
        return f.exists() && !f.isDirectory();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        List<Pelicula> peliculas = new ArrayList<>();
        var archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                peliculas.add(new Pelicula(linea));
                linea = entrada.readLine();
            }
            
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) throws EscrituraDatosEx{
        File archivo = new File(nombreArchivo);//en memoria
        try {
            //Para anexar información al archivo
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha " + (anexar ? "anexado" : "creado") + " información al archivo => "+pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir pelicula => "+ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        
        if(buscar == null){
            return "";
        }
        
        if(nombreArchivo == null){
            return "";
        }
        
        var archivo = new File(nombreArchivo);
        String resultado = "";
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                System.out.println("lectura = " + linea);
                if (linea.equalsIgnoreCase(buscar)) {
                    resultado = "Pelicula => "+linea+ " encontrada en el indice "+indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }
        
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);//en memoria
        try {
            //Para crear el archivo en el disco duro:
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo => " + nombreArchivo);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear fichero: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        if (nombreArchivo == null) {
            System.out.println("No existe el fichero");
            return;
        }

        File f = new File(nombreArchivo);
        if (f.delete()) {
            System.out.println("Fichero " + nombreArchivo + " eliminado correctamente");
        } else {
            System.out.println("Error al eliminar el fichero " + nombreArchivo);
        }
    }

}
