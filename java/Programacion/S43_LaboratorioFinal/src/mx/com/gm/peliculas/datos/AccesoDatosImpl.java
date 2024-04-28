package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

public class AccesoDatosImpl implements AccesoDatos {

    public AccesoDatosImpl() {
    }

    @Override
    public Boolean exist(String nombreArchivo) {
        File f = new File(nombreArchivo);
        return f.exists() && !f.isDirectory();
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        List<Pelicula> ps = new ArrayList<>();
        var archivo = new File(nombre);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var pelicula = entrada.readLine();
            while (pelicula != null) {
                if(!pelicula.isEmpty()){
                    System.out.println("Pelicula => "+pelicula);
                    ps.add(new Pelicula(pelicula));
                }
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return ps;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) {
        File archivo = new File(nombreArchivo);//en memoria
        try {
            //Para anexar información al archivo
            if (anexar) {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(pelicula);
                salida.close();
            } else {
                PrintWriter salida = new PrintWriter(archivo);
                salida.println(pelicula);
                salida.close();
            }

            System.out.println("Se ha " + (anexar ? "anexado" : "creado") + " información al archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var peliculas = entrada.readLine();
            var match = "";
            while (peliculas != null) {
                System.out.println("lectura = " + peliculas);
                if (peliculas.equals(buscar)) {
                    match = peliculas;
                    break;
                }
            }
            entrada.close();
            if (match.isEmpty()) {
                return "";
            } else {
                return match;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            return "";
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            return "";
        }
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);//en memoria
        try {
            //Para crear el archivo en el disco duro:
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo " + nombreArchivo);
            /*
            Cuando estemos trabajando con la clase PrintWriter y
            estamos creando un nuevo objeto de esta clase, este constructor
            puede arrojar un excepción.
             */
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        if(!exist(nombreArchivo)){
            System.out.println("No existe el fichero");
            return;
        }
        
        File f = new File(nombreArchivo);
        if(f.delete()){
            System.out.println("Fichero "+nombreArchivo+" eliminado correctamente");
        } else {
            System.out.println("Error al eliminar el fichero "+nombreArchivo);
        }
    }

}
