package com.ipartek.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ipartek.videoclub.domain.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, Integer>{
	@Query("from Alquiler where pk.idCliente=?1")
	Alquiler findByIdCliente( int idcliente);
}
