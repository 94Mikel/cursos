package com.ipartek.videoclub.service;

import java.util.List;

import com.ipartek.videoclub.domain.Cliente;

public interface ClienteService {
	public List<Cliente> getClientes();
	public Cliente GetClienteByNombre(String nombre);
}
