package com.ipartek.videoclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.videoclub.domain.Proveedor;
import com.ipartek.videoclub.repository.ProveedorRepository;
import com.ipartek.videoclub.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	@Autowired
	ProveedorRepository proveedorRepository;
	public List<Proveedor> getProveedores() {
		return proveedorRepository.findAll();
	}
	public Proveedor getProveedorByNombre(String nombre) {
		return proveedorRepository.findByNombre(nombre);
	}
}
