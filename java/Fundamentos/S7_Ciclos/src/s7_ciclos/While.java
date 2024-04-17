package s7_ciclos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mikel
 */
public class While {
    
    public static void main(String[] args) {
        
        var contador = 0;
        /*
        while (contador < 3) {            
            System.out.println("contador = " + contador);
            contador++;
        }
        */
        //Con do while se ejecuta el codigo al menos 1 vez
        do {            
            System.out.println("contador = " + contador);
            contador++;
        } while (contador < 3);
        
        
    }
    
}
