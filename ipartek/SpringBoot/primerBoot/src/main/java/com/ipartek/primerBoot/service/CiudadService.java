package com.ipartek.primerBoot.service;

import java.util.List;

import com.ipartek.primerBoot.domain.Ciudad;

public interface CiudadService {
	public List<Ciudad> getCiudades();
	public Ciudad getCiudadByNombre(String nombre);
	void inseratCiudad(Ciudad ciudad);
	
	
}
