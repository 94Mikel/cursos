package com.ipartek.videoclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ipartek.videoclub.domain.Alquiler;
import com.ipartek.videoclub.repository.AlquilerRepository;
import com.ipartek.videoclub.service.AlquilerService;

@Service
public class AlquilerServiceImpl implements AlquilerService{

	@Autowired
	AlquilerRepository alquilerRepository;
	
	public List<Alquiler> getAlquileres() {
		return (List<Alquiler>) alquilerRepository.findAll();
	}
	
	public Alquiler getAlquilerByidCliente(@PathVariable int idcliente) {
		return alquilerRepository.findByIdCliente(idcliente);
	}
}
