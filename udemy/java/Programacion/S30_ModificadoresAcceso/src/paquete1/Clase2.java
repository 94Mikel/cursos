package paquete1;

public class Clase2 {
    
    //ALL PROTECTED
    
    protected String atributoProtected = "Valor atributo protected";
    
    protected Clase2(){
        System.out.println("Constructor protected");
    }
    
    public Clase2(String arg){
        System.out.println("Constructor publico");
    }
    
    protected void metodoProtected(){
        System.out.println("Metodo protected");
    }
}
