package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{

    private final IAccesoDatos datos;
    
    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        Boolean anexar = false;
        try {
            this.datos.exist(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listando peliculas");
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("pelicula => " + pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace();
        }
        
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace();
        }
        System.out.println("resultado => " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        
        try {
            if(this.datos.exist(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
                return;
            }
            
            datos.crear(NOMBRE_RECURSO);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace();
        }
        
        
        
        
    }
    
    
}
