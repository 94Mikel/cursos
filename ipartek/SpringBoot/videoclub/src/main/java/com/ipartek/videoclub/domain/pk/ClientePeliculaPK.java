package com.ipartek.videoclub.domain.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ipartek.videoclub.domain.Pelicula;

@Embeddable
public class ClientePeliculaPK implements Serializable{

	private static final long serialVersionUID = 1L;


	@Column(name="cliente_idcliente")
	private Integer idCliente;
	
	
	@ManyToOne
	@JoinColumn(name="pelicula_idpelicula")
	private Pelicula pelicula;


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public Pelicula getPelicula() {
		return pelicula;
	}


	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
	
}
