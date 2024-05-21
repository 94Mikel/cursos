package com.ipartek.videoclub.service;

import java.util.List;

import com.ipartek.videoclub.domain.Proveedor;

public interface ProveedorService {
	public List<Proveedor> getProveedores();
	public Proveedor getProveedorByNombre(String nombre);
}
