package com.ipartek.videoclub.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="pelicula")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idpelicula;
	
	@Column
	private String titulo;
	
	@Column
	private String director;
	
	@Column
	private Date fecha_estreno;
	
	@Column
	private String descripcion;
	
	@Column
	private boolean disponibilidad;
	
	@Column
	private double precio_alquiler;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="proveedor_idproveedor")
	private Proveedor proveedor;
	
	public Pelicula(){}
	
	public Pelicula(int idpelicula, String titulo, String director, Date fecha_estreno, String descripcion,
			boolean disponibilidad, double precio_alquiler, Proveedor proveedor) {
		super();
		setIdpelicula(idpelicula);
		setTitulo(titulo);
		setDirector(director);
		setFecha_estreno(fecha_estreno);
		setDescripcion(descripcion);
		setDisponibilidad(disponibilidad);
		setPrecio_alquiler(precio_alquiler);
		setProveedor(proveedor);
	}

	public int getIdpelicula() {
		return idpelicula;
	}

	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Date getFecha_estreno() {
		return fecha_estreno;
	}

	public void setFecha_estreno(Date fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public double getPrecio_alquiler() {
		return precio_alquiler;
	}

	public void setPrecio_alquiler(double precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
