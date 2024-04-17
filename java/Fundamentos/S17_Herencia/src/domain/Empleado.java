
package domain;

public class Empleado extends Persona{
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;
    
    //Sobrecarga de constructores
    public Empleado () {
        //super(); => Aquí hace una llamada a la clase Persona automaticamente.
        this.idEmpleado = ++Empleado.contadorEmpleado;
    }

    /*
    public Empleado(String nombre, char genero, int edad, String direccion) {
        super(nombre, genero, edad, direccion);//Para crear el objeto Padre
    }
    */
    
    

    public Empleado(String nombre, double sueldo) {
        //super(nombre);
        this();//Llamamos al constructo vacio de la clase Empleado.
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        //Para realizar la concatenación se utiliza la clase StringBuilder.
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado=").append(this.idEmpleado);
        sb.append(", sueldo=").append(this.sueldo);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
    
}
