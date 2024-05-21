package com.ipartek.videoclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.videoclub.domain.Cliente;
import com.ipartek.videoclub.repository.ClienteRepository;
import com.ipartek.videoclub.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}
	public Cliente GetClienteByNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);
	}
}
