package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;

public interface AccesoDatos {
    
    Boolean exist(String nombreArchivo);
    
    List<Pelicula> listar(String nombre);
    
    void escribir(Pelicula pelicula, String nombre, Boolean anexar);
    
    String buscar(String nombreArchivo, String buscar);
    
    void crear(String nombreArchivo);
    
    void borrar(String nombreArchivo);
    
}
