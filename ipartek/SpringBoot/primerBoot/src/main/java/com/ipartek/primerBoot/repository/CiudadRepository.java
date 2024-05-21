package com.ipartek.primerBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ipartek.primerBoot.domain.Ciudad;


public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	Ciudad findByNombre(String nombre);
	Ciudad insertCiudad();
}
