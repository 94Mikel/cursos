package domain;

public class Persona {

    private final int idPersona;
    private static int contadorPersonas;

    //Inicializacion bloque estatico(se carga al crear la clase)
    static {
        System.out.println("Ejecucion bloque estatico");
        ++Persona.contadorPersonas;
        //idPersona = 10;
    }

    //Inicializacion bloque no estatico(contexto dinámico)
    //Se carga al crear el objeto
    {
        System.out.println("Ejecucion de bloque no estatico");
        this.idPersona = Persona.contadorPersonas++;
    }

    public Persona() {
        System.out.println("Ejecucion del constructor");
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append('}');
        return sb.toString();
    }
    
    

}
