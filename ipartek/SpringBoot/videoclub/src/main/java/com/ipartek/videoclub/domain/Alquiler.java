package com.ipartek.videoclub.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ipartek.videoclub.domain.pk.ClientePeliculaPK;

@Entity
@Table(name="cliente_has_pelicula")
public class Alquiler {

	@EmbeddedId
	private ClientePeliculaPK pk;
	
	@Column
	private Date fecha_alquiler;
	
	@Column
	private Date fecha_devolucion;
	
	public ClientePeliculaPK getPk() {
		return pk;
	}

	public void setPk(ClientePeliculaPK pk) {
		this.pk = pk;
	}

	public Date getFecha_alquiler() {
		return fecha_alquiler;
	}

	public void setFecha_alquiler(Date fecha_alquiler) {
		this.fecha_alquiler = fecha_alquiler;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	
}
