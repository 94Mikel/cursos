package com.ipartek.videoclub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.videoclub.domain.Alquiler;
import com.ipartek.videoclub.service.AlquilerService;

@CrossOrigin(origins = {"http://localhost"})
@RestController
@RequestMapping("/alquileres")
public class AlquilerController {

	@Autowired
	AlquilerService alquilerService;
	
	@GetMapping(produces="application/json")
	public List<Alquiler> getAlquileres(){
		return (List<Alquiler>) alquilerService.getAlquileres();
	}
	
	@GetMapping(path="/{idcliente}",produces="application/json")
	public Alquiler getAlquilerByidCliente(@PathVariable int idcliente) {
		return alquilerService.getAlquilerByidCliente(idcliente);
	}

}
