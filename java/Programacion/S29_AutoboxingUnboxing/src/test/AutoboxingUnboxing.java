package test;

public class AutoboxingUnboxing {
    public static void main(String[] args) {
        //Clases Envolventes de tipo primitivos
        
        //Autboxing. Estamos envolviedo el tipo primitivo en un tipo.
        Integer entero = 10;
        System.out.println("entero = " + entero);
        
        //Podemos obtener mas informacion con las clases envolventes(toString(),toDouble...).
        System.out.println("entero = " + entero.doubleValue());
        
        //Unboxing. crear otra variable con el valor almacenado de otro objeto(variable).
        Integer entero2 = entero;
        System.out.println("entero2 = " + entero2);
        
        
    }
}
