package com.ipartek.primerBoot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.primerBoot.domain.Pais;
import com.ipartek.primerBoot.repository.PaisRepository;
import com.ipartek.primerBoot.service.PaisService;


@Service
public class PaisServiceImpl implements PaisService{

	@Autowired
	PaisRepository paisRepository;
	
	@Override
	public List<Pais> getPaises() {
		return paisRepository.findAll();
	}

	@Override
	public Pais getPaisByNombre(String nombre) {
		return paisRepository.findByNombre(nombre);
	}
	

}
