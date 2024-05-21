package com.ipartek.videoclub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.videoclub.domain.Proveedor;
import com.ipartek.videoclub.service.ProveedorService;

@CrossOrigin(origins = {"http://localhost"})
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

	@Autowired
	ProveedorService proveedorService;
	
	@GetMapping(produces="application/json")
	public List<Proveedor> getProveedores(){
		return (List<Proveedor>) proveedorService.getProveedores();
	} 
	
	@GetMapping(path="/{nombre}", produces="application/json")
	public Proveedor getProveedorByNombre(@PathVariable String nombre) {
		return proveedorService.getProveedorByNombre(nombre);
	}
}
