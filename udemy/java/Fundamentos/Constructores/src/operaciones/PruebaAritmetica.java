
package operaciones;

/**
 *
 * @author mikel
 */
public class PruebaAritmetica {
    public static void main(String[] args) {
        
        Aritmetica aritmetica1 = new Aritmetica();
        System.out.println("aritmetica a: "+aritmetica1.a);
        System.out.println("aritmetica b: "+aritmetica1.b);
        
        Aritmetica aritmetica2 = new Aritmetica(5,8);
        System.out.println("aritmetica2 a = " + aritmetica2.a);
        System.out.println("aritmetica2 b = " + aritmetica2.b);
        
    }
}
