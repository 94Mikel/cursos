package test;

import datos.*;
import domain.PersonaDTO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author mikel
 Hay que realizar la excepcion con throws en la clase PersonaDaoJDBC para que reporte el error.
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
            
            //En el lado izquierdo el interface y en la creacion de objeto(derecha) el nombre de la clase
            //Para separar capas y responsabilidades
            PersonaDao personaDao = new PersonaDaoJDBC(conexion); 
            
            List<PersonaDTO> persona = personaDao.select();
            for (PersonaDTO personaDTO : persona) {
                System.out.println("personaDTO = " + personaDTO);
            }
            
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
