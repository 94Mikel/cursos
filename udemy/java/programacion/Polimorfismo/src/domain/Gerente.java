package domain;

public class Gerente extends Empleado{
    
    private String departamento;

    public Gerente(String departamento, String nombre, double sueldo) {
        super(nombre, sueldo);
        this.departamento = departamento;
    }
    
    //Sobresecritura
    //anotación => para decirla al compialdo que es una sobrescritura
    //No se pude poner el acceso mas restrictivo que el del metodo padre.
    @Override 
    public String obtenerDetalles(){
        //Con super podemos acceder al metodo del padre.
        return super.obtenerDetalles() + ", departamento: "+this.departamento;
    }
    
}
