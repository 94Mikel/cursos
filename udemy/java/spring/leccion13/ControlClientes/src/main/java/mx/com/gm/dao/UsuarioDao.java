package mx.com.gm.dao;

import mx.com.gm.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username);//El metodo se tiene que escribir como esta "findByUsername" ya que es parte de la seguridad de spring
    
}
