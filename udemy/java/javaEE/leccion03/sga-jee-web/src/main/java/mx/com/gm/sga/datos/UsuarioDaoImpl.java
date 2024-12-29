/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.datos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author mikel
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao{
    
    @PersistenceContext(unitName="PersonaPU")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
    
}
