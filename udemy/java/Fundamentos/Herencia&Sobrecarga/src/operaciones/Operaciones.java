package operaciones;

//SOBRECARGA DE METODOS

public class Operaciones {
    
    public static int sumar(int a, int b){
        System.out.println("Sumar(int a, int b)");
        return a + b;
    }
    
    //El segundo mentod no puede ser mas restrictivo que el primero. 
    //Si es public no se puede el segundo private...
    public static double sumar(double a, double b){
        System.out.println("Sumar(double a, double, b)");
        return a + b;
    }
}
