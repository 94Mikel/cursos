
//Capa de presentacion o de vista
package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.servicios.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        int opcion = -1;
        
        while (opcion != 0) {            
            System.out.println("Seleccione la opción:");
            System.out.println("1.-Iniciar catalogo películas");
            System.out.println("2.-Agregar película");
            System.out.println("3.-Listar Películas");
            System.out.println("4.-Buscar película");
            System.out.println("0.-Salir");
            
            opcion = Integer.parseInt(s.nextLine());
            
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula:");
                    var nombrePelicula = s.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar");
                    var buscar = s.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción desconocida");
                    break;
            }
            
            
        }
        
        
    }
    
}
