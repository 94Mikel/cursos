package com.ipartek.primerBoot.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.primerBoot.domain.Pais;
import com.ipartek.primerBoot.repository.PaisRepository;
import com.ipartek.primerBoot.service.PaisService;

@CrossOrigin(origins = {"http://localhost"})
@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	PaisService paisService;
	
	@GetMapping(produces ="application/json")
	public List<Pais> getPaises(){
		return (List<Pais>) paisService.getPaises();
	}
	
	@GetMapping(path="/{nombre}", produces = "application/json")
	public Pais getPaisByNombre(@PathVariable String nombre){
		System.out.println(paisService.getPaisByNombre(nombre));
		return paisService.getPaisByNombre(nombre);
	}
	
	
}
