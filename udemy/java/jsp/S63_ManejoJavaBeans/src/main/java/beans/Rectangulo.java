package beans;

/**
 *
 * @author mikel
 */
public class Rectangulo {
    
    private int base;
    private int altura;
    
    //Si no se especifica el constructor el compilador crea un constructor vacio

    public int getBase() {
        return this.base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getArea(){
        return this.base * this.altura;
    }
    
    
    
}
