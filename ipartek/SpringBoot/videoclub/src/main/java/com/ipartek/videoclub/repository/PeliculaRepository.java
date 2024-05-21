package com.ipartek.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.videoclub.domain.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{

	Pelicula findByTitulo(String titulo);
}
