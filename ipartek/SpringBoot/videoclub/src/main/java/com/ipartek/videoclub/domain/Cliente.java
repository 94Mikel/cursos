package com.ipartek.videoclub.domain;

import java.util.Set;

import javax.persistence.*;

import com.ipartek.videoclub.excepciones.EmptyStackException;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idcliente;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String direccion;
	
	@Column
	private String email;
	
	@Column
	private String telefono;
	
	@Column
	private String numseguridadsocial;
	
	@Column
	private String contrasena;
	
	@Column
	private String cuentabancaria;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Pelicula> Peliculas;
	
	public Cliente(){}
	
	public Cliente(int idcliente, String nombre, String apellidos, String direccion, String email, String telefono,
			String numseguridadsocial, String contrasena,String cuentabancaria) {
		super();
		setIdcliente(idcliente);
		setNombre(nombre);
		setApellidos(apellidos);
		setDirecion(direccion);
		setEmail(email);
		setTelefono(telefono);
		setnumseguridadsocial(numseguridadsocial);
		setContrasena(contrasena);
		setCuentabancaria(cuentabancaria);
	}

	public String getCuentabancaria() {
		return cuentabancaria;
	}

	public void setCuentabancaria(String cuentabancaria) {
		if("".equals(cuentabancaria)) {
			throw new EmptyStackException("La cuenta bancaria esta vacia");
		}
		this.cuentabancaria = cuentabancaria;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		if(idcliente==0) {
			throw new EmptyStackException("El campo idcliente esta vacio");
		}
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if("".equals(nombre)) {
			throw new EmptyStackException("El campo nombre esta vacio");
		}
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if("".equals(apellidos)) {
			throw new EmptyStackException("El campo apellidos esta vacio");
		}
		this.apellidos = apellidos;
	}

	public String getDirecion() {
		return direccion;
	}

	public void setDirecion(String direccion) {
		if("".equals(direccion)) {
			throw new EmptyStackException("El campo direccion esta vacio");
		}
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if("".equals(email)) {
			throw new EmptyStackException("El campo email esta vacio");
		}
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if("".equals(telefono)) {
			throw new EmptyStackException("El campo telefono esta vacio");
		}
		this.telefono = telefono;
	}

	public String getnumseguridadsocial() {
		return numseguridadsocial;
	}

	public void setnumseguridadsocial(String numseguridadsocial) {
		if("".equals(numseguridadsocial)) {
			throw new EmptyStackException("El campo numseguridadsocial esta vacio");
		}
		this.numseguridadsocial = numseguridadsocial;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		if("".equals(contrasena)) {
			throw new EmptyStackException("El campo contrasena esta vacio");
		}
		this.contrasena = contrasena;
	}
	
}
