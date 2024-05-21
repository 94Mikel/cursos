package com.ipartek.videoclub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.videoclub.domain.Pelicula;
import com.ipartek.videoclub.service.PeliculaService;

//@CrossOrigin(origins = {"http://localhost"})
@RestController
@RequestMapping(value="/peliculas")
public class PeliculaController{
	
	@Autowired
	PeliculaService peliculaService;
	
	@GetMapping(produces="application/json")
	public List<Pelicula> getPeliculas(){
		return (List<Pelicula>) peliculaService.getPeliculas();
	}
	
	@GetMapping(path="/{titulo}",produces="application/json")
	public Pelicula getPeliculaByTitulo(@PathVariable String titulo) {
		return peliculaService.getPelicualByTitulo(titulo);
	}
}
