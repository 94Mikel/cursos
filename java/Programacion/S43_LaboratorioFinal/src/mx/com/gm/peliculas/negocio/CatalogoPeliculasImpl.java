package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{

    AccesoDatosImpl acceso = new AccesoDatosImpl();
    
    public CatalogoPeliculasImpl() {
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        acceso.escribir(new Pelicula(nombrePelicula), nombreArchivo, true);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        
        System.out.println("Listando peliculas");
        var ps = acceso.listar(nombreArchivo);
        System.out.println("ps => "+ps.toString());
        for (Pelicula p : ps) {
            System.out.println("peslicula => " + p.getNombre());
        }
        
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        acceso.buscar(nombreArchivo, buscar);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        acceso.crear(nombreArchivo);
    }
    
    
}
