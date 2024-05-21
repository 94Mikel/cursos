package com.ipartek.primerBoot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.primerBoot.domain.Ciudad;
import com.ipartek.primerBoot.repository.CiudadRepository;
import com.ipartek.primerBoot.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService{
	@Autowired
	CiudadRepository ciudadRepository;
	@Override
	public List<Ciudad> getCiudades() {
		return ciudadRepository.findAll();
	}
	@Override
	public Ciudad getCiudadByNombre(String nombre) {
		return ciudadRepository.findByNombre(nombre);
	}
	@Override
	public void inseratCiudad(Ciudad ciudad) {
		ciudadRepository.save(ciudad);
	}
}
