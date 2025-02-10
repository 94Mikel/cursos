/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gm.rh.repositorio;

import gm.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mikel
 */
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer>{
    
}
