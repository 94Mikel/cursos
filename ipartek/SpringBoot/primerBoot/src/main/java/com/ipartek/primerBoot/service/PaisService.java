package com.ipartek.primerBoot.service;
import java.util.List;
import com.ipartek.primerBoot.domain.Pais;

public interface PaisService {
	public List<Pais> getPaises();
	public Pais getPaisByNombre(String nombre);
}
