package tarea2;

import java.util.Scanner;

/**
 *
 * @author mikel
 */
public class Libro {
    public static void main(String[] args) {
        
        Scanner console = new Scanner(System.in);
        
        System.out.println("Proporciona el titulo: ");
        String titulo = console.nextLine();
        
        System.out.println("Proporciona el autor: ");
        String autor = console.nextLine();
        
        System.out.println(titulo + " fue escrito por " + autor);
        
    }
}
