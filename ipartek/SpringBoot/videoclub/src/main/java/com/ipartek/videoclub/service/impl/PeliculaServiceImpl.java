package com.ipartek.videoclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ipartek.videoclub.domain.Pelicula;
import com.ipartek.videoclub.repository.PeliculaRepository;
import com.ipartek.videoclub.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService{
	@Autowired
	PeliculaRepository peliculaRepository;
	public List<Pelicula> getPeliculas() {
		return peliculaRepository.findAll();
	}
	public Pelicula getPelicualByTitulo(String titulo) {
		return peliculaRepository.findByTitulo(titulo);
	}
}
