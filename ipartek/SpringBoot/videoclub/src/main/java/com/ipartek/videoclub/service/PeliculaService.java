package com.ipartek.videoclub.service;

import java.util.List;

import com.ipartek.videoclub.domain.Pelicula;

public interface PeliculaService {
	public List<Pelicula> getPeliculas();
	public Pelicula getPelicualByTitulo(String titulo);
}
