package test;

import datos.Conexion;
import datos.UsuarioDao;
import datos.UsuarioDaoJDBC;
import domain.UsuarioDTO;
import java.sql.*;
import java.util.List;

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
            
            UsuarioDao usuarioDao = new UsuarioDaoJDBC();
            List<UsuarioDTO> usuario = usuarioDao.select();
            for (UsuarioDTO usuarioDTO : usuario) {
                System.out.println("usuarioDTO = " + usuarioDTO);
            }
            
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
