/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

import java.util.Scanner;

/**
 *
 * @author mikel
 */
public class TareaRectangulo {

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
            System.out.println("Proporcionado un número alto");
            System.exit(alto);
        }

        System.out.println("Proporciona el ancho: ");

        try {
            ancho = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("Proporcionado un número ancho");
            System.exit(ancho);
        }

        var area = alto * ancho;
        var perimetro = 2 * (alto + ancho);

        System.out.println("Área: " + area);
        System.out.println("perímetro: " + perimetro);

    }

}
