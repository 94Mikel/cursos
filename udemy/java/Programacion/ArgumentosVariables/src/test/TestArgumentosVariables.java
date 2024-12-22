
package test;

public class TestArgumentosVariables {
    public static void main(String[] args) {
        //Cantidad de argumetos varia
        imprimirNumeros(3,4,5);
        imprimirNumeros(1,2);
        variosParametros("Juan", 8,9,10);
    }
    
    private static void variosParametros(String nombre, int... numeros){
        System.out.println("nombre = " + nombre);
        imprimirNumeros(numeros);
    }
    
    //int... numeros <= vamos a recibir argumetos variables(no sabemos la cantidad de elemetos que vamos a recibir)
    private static void imprimirNumeros(int... numeros){
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("elemento: "+numeros[i]);
        }
    }
}
