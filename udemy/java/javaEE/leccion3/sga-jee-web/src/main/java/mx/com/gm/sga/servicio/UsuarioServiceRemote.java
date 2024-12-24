/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.sga.servicio;

import jakarta.ejb.Remote;
import java.util.List;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author mikel
 */
@Remote
public interface UsuarioServiceRemote {
    
    public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
}
