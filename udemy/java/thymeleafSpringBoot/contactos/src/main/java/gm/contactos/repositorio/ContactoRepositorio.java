package gm.contactos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import gm.contactos.modelo.Contacto;

public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {
}
