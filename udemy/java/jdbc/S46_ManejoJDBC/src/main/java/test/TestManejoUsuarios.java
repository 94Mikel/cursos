package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author mikel
 */
public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDao = new UsuarioDAO();

        //Insertar usuario
        //usuarioDao.insertar(new Usuario("Pedro", "zxcvb"));
        
        
        //Modificar usuario
        //usuarioDao.actualizar(new Usuario(4,"Pepe", "poiuy"));
        
        //Eliminar usuario
        //usuarioDao.eliminar(new Usuario(4));
        
        //-- LISTAR USUARIOS --
        List<Usuario> usuariosLista = usuarioDao.Seleccionar();
        for (Usuario usuario : usuariosLista) {
            System.out.println("usuario = " + usuario);
        }
        
        
    }
    
}
