package tarea3;

import java.util.Scanner;

public class TiendaLibros {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Proporciona el nombre:");    
        String nombre = console.nextLine();
        System.out.println("Proporciona el id:");
        int id = Integer.parseInt(console.nextLine());
        System.out.println("Proporciona el precio:");
        Double precio = Double.parseDouble(console.nextLine());
        System.out.println("Proporciona el envio gratuito:");
        Boolean envioGratuito = Boolean.parseBoolean(console.nextLine());

        System.out.println(nombre + " #"+id);
        System.out.println("Precio: $"+precio);
        System.out.println("Envio gratuito: "+envioGratuito);
    }
}
