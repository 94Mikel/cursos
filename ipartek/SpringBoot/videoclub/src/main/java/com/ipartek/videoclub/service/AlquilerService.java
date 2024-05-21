package com.ipartek.videoclub.service;

import java.util.List;
import com.ipartek.videoclub.domain.Alquiler;

public interface AlquilerService {

	public List<Alquiler> getAlquileres();
	public Alquiler getAlquilerByidCliente(int idcliente);
}
