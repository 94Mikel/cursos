package com.ipartek.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.videoclub.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	Cliente findByNombre(String nombre);
	
}
