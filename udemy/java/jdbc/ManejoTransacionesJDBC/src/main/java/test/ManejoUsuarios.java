package test;

import datos.Conexion;
import datos.UsuarioJDBC;
import domain.Usuario;
import java.sql.*;

/**
 *
 * @author mikel
 */
public class ManejoUsuarios {
    public static void main(String[] args) {
        
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            
            if(conexion.getAutoCommit()){
                //Poner autocommit false
                conexion.setAutoCommit(false);
            }
            
            UsuarioJDBC usuarioJdbc = new UsuarioJDBC();
            
            Usuario cambioUsuario = new Usuario();
            cambioUsuario.setIdUsuario(1);
            cambioUsuario.setUsuario("Pepe");
            cambioUsuario.setPassword("poiuy");
            usuarioJdbc.update(cambioUsuario);
            
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsuario("Alfonso");
            nuevoUsuario.setPassword("polikus");
            usuarioJdbc.insert(nuevoUsuario);
            
            conexion.commit();
            System.out.println("Realizado transaccion de usuario");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Se procede al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
    
}
