package doman;

public class Rectangulo extends FiguraGeometrica {
    
    public Rectangulo(String tipoFigura) {
        super(tipoFigura);
    }
    
    //Implementando, no sobrescribiendo
    //Implementado metodo dibujar
    //Cuando se implementa no es abstract.
    @Override
    public void dibujar() {
        //obtener el nombre de la clase.
        System.out.println("Se imprime un: " + this.getClass().getSimpleName());
    }
}
