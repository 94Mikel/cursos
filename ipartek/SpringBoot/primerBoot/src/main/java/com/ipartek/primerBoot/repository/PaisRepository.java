package com.ipartek.primerBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.primerBoot.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer>{
	Pais findByNombre(String nombre);
}
