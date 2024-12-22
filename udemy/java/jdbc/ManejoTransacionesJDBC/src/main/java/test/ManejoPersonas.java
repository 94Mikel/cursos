package test;

import datos.*;
import domain.Persona;
import java.sql.*;

/**
 *
 * @author mikel
 * Hay que realizar la excepcion con throws en la clase PersonaJDBC para que reporte el error.
 */
public class ManejoPersonas {
    public static void main(String[] args) {
        
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                //No realizar el commit de manera automatica(por default true).
                conexion.setAutoCommit(false);
            }
            
            //Transaccion realizar varias sentencias sql
            
            PersonaJDBC personaJdbc = new PersonaJDBC(conexion); 
            
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(3);
            cambioPersona.setNombre("Pepe");
            cambioPersona.setApellido("Martinez");
            cambioPersona.setEmail("PMartinez@gmail.com");
            cambioPersona.setTelefono("685457214");
            personaJdbc.update(cambioPersona);
            
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            nuevaPersona.setApellido("Bilbaooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
            nuevaPersona.setApellido("Ramirez");
            personaJdbc.insert(nuevaPersona);
            
            //Realizar el commit de la transaccion de manera manual
            conexion.commit();
            System.out.println("Se ha realizado el commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                //Si ocurre un error en el try no realiza ninguna operacion con la bd
                //Y se ejecuta el rollback.
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
    
}
