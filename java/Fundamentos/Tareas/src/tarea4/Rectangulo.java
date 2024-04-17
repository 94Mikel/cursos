package tarea4;

import java.util.Scanner;

public class Rectangulo {

    public static void main(String[] args) {

        //Calcular área y perímetro de un rectángulo
        /*
            Area => a * b
            Perímetro => 2(a+b)
         */
        var alto = 0;
        var ancho = 0;

        var console = new Scanner(System.in);

        System.out.println("Proporciona el alto: ");

        try {
            alto = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("Proporciona un número entero5");
            System.exit(alto);
        }

        System.out.println("Proporciona el ancho: ");

        try {
            ancho = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("Proporciona un número entero");
            System.exit(ancho);
        }

        var area = alto * ancho;
        var perimetro = 2 * (alto + ancho);

        System.out.println("Área: " + area);
        System.out.println("perímetro: " + perimetro);

    }

}
