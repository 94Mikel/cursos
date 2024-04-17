package operaciones;

/**
 *
 * @author mikel
 */
public class Aritmetica {
    
    //Atributos de la clase
    int a;//default 0
    int b;
    
    //Constructor vacio
    public Aritmetica(){
        System.out.println("Ejecutando constructor");
    }
    
    public Aritmetica(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Constructor con argumentos");
    }
    
    //Metodo
    public void sumar(){
        int resultado = this.a + this.b;
        System.out.println("resultado = " + resultado);
    }
    
    public int sumarConRetorno(){
        return this.a + this.b;
    }
    
    public int sumarConArgumentos(int a, int b){
        this.a = a;//El argumento a se asigna al atributo this.a
        this.b = b;
        //return a + b;
        return this.sumarConRetorno();
    }
    
}
