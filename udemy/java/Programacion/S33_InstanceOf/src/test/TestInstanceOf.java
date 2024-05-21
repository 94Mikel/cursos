package test;

import domain.*;

public class TestInstanceOf {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan", 5000);
        //determinarTipo(empleado);
//        empleado = new Gerente("Contabilidad", "Karla", 10000);
        determinarTipo(empleado);
    }

    public static void determinarTipo(Empleado empleado) {
        //Si esta variable es una instancia de la clase hija.
        //Se pregunta desde las clases menos genericas a las mas genericas
        if (empleado instanceof Gerente) {
            //se Utiliza instanceof para saber si podemos hacer la conversion de forma segura.
            System.out.println("Es de tipo gerente");
            //Convertir empleado a gerente.
            Gerente gerente = (Gerente)empleado;//Se puede utilizar ((Gerente)empleado).getDepartamento()
            System.out.println("gerente = " + gerente.getDepartamento());
        } 
        else if (empleado instanceof Empleado) {
            System.out.println("Es de tipo empleado");
            /*
            No se puede convertir el tipo empleado en tipo gerente.
            Gerente gerente = (Gerente)empleado;
            System.out.println("gerente = " + gerente.getDepartamento());
            */
            System.out.println("empleado = " + empleado.getNombre());
        } 
        else if (empleado instanceof Object){
            //Aqui no teneos acceso a metodos de la clase empleado ya que es de tipo object
            System.out.println("Es de tipo object");
            empleado.toString();
        }
    }

}
