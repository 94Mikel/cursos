package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        
        System.out.println("Seleccione la opción:");
        System.out.println("1.-Iniciar catalogo películas");
        System.out.println("2.-Agregar película");
        System.out.println("3.-Listar Películas");
        System.out.println("4.-Buscar película");
        System.out.println("0.-Salir");
        
        Scanner s = new Scanner(System.in);
        CatalogoPeliculasImpl catalogo = new CatalogoPeliculasImpl();
        var line = s.nextLine();
        
        if(line.isEmpty()){
            System.out.println("Seleccione la opcion");
            return;
        }
        
        int option;
        
        try {
            option = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Exception = " + e.getMessage());
            return;
        }
        
        if(option == 0){
            System.out.println("Salida => "+option);
            return;
        }
        
        var archivo = "";
        var pelicula = "";
        var buscar = "";
        
        if(option == 1){
            System.out.println("-- Iniciar catalogo películas --");
            System.out.println("Inserte el nombre del archivo:");
            line = s.nextLine();
            catalogo.iniciarArchivo(line);
            return;
        }
        
        if(option == 2){
            System.out.println("-- Agregar película --");
            
            while (archivo.isEmpty()) {                
                System.out.println("Inserte el nombre del archivo:");
                archivo = s.nextLine();
                if(archivo.isEmpty()){
                    System.out.println("Nombre del archivo incorrecto");
                }
            }
            
            while (pelicula.isEmpty()) {                
                System.out.println("Inserte el nombre de la pelicula:");
                pelicula = s.nextLine();
                if(pelicula.isEmpty()){
                    System.out.println("Nombre de la pelicula incorrecto");
                }
            }
            
            catalogo.agregarPelicula(pelicula, archivo);
            return;
        }
        
        if(option == 3){
            System.out.println("-- Listar películas --");
            
            while (archivo.isEmpty()) {                
                System.out.println("Escribe el nombre del archivo:");
                archivo = s.nextLine();
                if(archivo.isEmpty()){
                    System.out.println("El nombre del archivo incorrecto");
                }
            }
            
            //System.out.println("Listar pelicula "+archivo+" fin");
            
            catalogo.listarPeliculas(archivo);
            
            return;
        }
        
        if(option == 4){
            System.out.println("-- Buscar películas --");
            
            while(archivo.isEmpty()){
                System.out.println("Ecribe el nombre del archivo:");
                archivo = s.nextLine();
                if(archivo.isEmpty()){
                    System.out.println("Nombre del archivo incorrecto");
                }
            }
            
            while (buscar.isEmpty()) {                
                System.out.println("Escribe la busqueda:");
                buscar = s.nextLine();
                if(buscar.isEmpty()){
                    System.out.println("Busqueda incorrecta");
                }
            }
            
            
            catalogo.buscarPelicula(archivo, buscar);
            
            return;
        }
        
        System.out.println("La opción "+option+" no existe");
        
        
    }
    
}
