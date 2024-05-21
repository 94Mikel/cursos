package com.ipartek.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.videoclub.domain.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	Proveedor findByNombre(String nombre);
}
