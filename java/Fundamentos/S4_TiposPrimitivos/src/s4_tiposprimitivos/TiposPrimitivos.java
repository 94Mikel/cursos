package s4_tiposprimitivos;


import java.util.Scanner;

/**
 *
 * @author mikel
 * 
 */
public class TiposPrimitivos {

    //El metodo main se ejecuta automáticamente para para iniciar el programa.
    public static void main(String args[]) {

        String nombre = "";
        int id = 1;
        double precio = 0.0;
        boolean envioGratuito = false;

        var console = new Scanner(System.in);

        System.out.println("Proporciona el nombre: ");
        nombre = console.nextLine();
        
        
        System.out.println("Proporciona el id: ");
        try {
            id = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("No ha proporcionado un número");
        }
        

        System.out.println("Proporciona el precio: ");
        try {
            precio = Double.parseDouble(console.nextLine());
        } catch (Exception e) {
            System.out.println("No ha proporcionado un número");
        }

        System.out.println("Proporciona el envio gratuito: ");
           
        var result = console.nextLine();
        if (!result.equals("si") && !result.equals("no")){
            System.out.println("si o no, Proporciona el envio gratuito:");
            result = console.nextLine();
        }
        
        envioGratuito = result.equals("si");
        
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("precio = $" + precio);
        System.out.println("envioGratuito = " + envioGratuito);

    }
}
