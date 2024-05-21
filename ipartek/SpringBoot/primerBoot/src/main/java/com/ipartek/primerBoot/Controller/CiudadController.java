package com.ipartek.primerBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.primerBoot.domain.Ciudad;
import com.ipartek.primerBoot.service.CiudadService;

@CrossOrigin(origins = {"http://localhost"})
@RestController
@RequestMapping("/ciudades")
public class CiudadController {

	@Autowired
	CiudadService ciudadService;
	
	@GetMapping(produces ="application/json")
	public List<Ciudad> getPaises(){
		return (List<Ciudad>) ciudadService.getCiudades();
	}
	
	@GetMapping(path="/{nombre}", produces = "application/json")
	public Ciudad getCiudadByNombre(@PathVariable String nombre){
		return ciudadService.getCiudadByNombre(nombre);
	}
}
