package tarea5;

import java.util.Scanner;

public class NumeroMayor {
    public static void main(String[] args) {
        int numero1;
        int numero2;
        var console = new Scanner(System.in);
    
        System.out.println("Tarea5 => El mayor de dos números");
        System.out.println("Proporciona el numero1:");
        numero1 = Integer.parseInt(console.nextLine());
                
        System.out.println("Proporciona el numero2:");
        numero2 = Integer.parseInt(console.nextLine());
        
        var resultado = numero1 > numero2 ? numero1 : numero2;
        System.out.println("El numero mayor es: "+resultado);
        
    }
}
