package com.ipartek.videoclub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.text.DefaultEditorKit.CutAction;

import junit.extensions.ExceptionTestCase;

@Entity
@Table(name="proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idproveedor;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String webproveedor;
	
	@Column
	private String cuenta_bancaria;
	
	public Proveedor(){}

	public Proveedor(int idproveedor, String nombre, String direccion, String webproveedor, String cuenta_bancaria) {
		super();
		setIdproveedor(idproveedor);
		setNombre(nombre);
		setDireccion(direccion);
		setWebproveedor(webproveedor);
		setCuenta_bancaria(cuenta_bancaria);
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getWebproveedor() {
		return webproveedor;
	}

	public void setWebproveedor(String webproveedor) {
		this.webproveedor = webproveedor;
	}

	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(String cuenta_bancaria) {
		if(cuenta_bancaria.length()<=0 || cuenta_bancaria.length()>11) {
			System.out.println("la cuenta bancaria no es correcta");
		}else {
			this.cuenta_bancaria = cuenta_bancaria;
		}
	}
	
}
