package com.ipartek.entidades;

public class Ciudad {

	String nombre,tipoCiudad;
	int poblacionHombre,poblacionMujeres,poblacionTotal;
	
	public Ciudad() {}

	
	public String getTipoCiudad() {
		return tipoCiudad;
	}


	public void setTipoCiudad(String tipoCiudad) {
		this.tipoCiudad = tipoCiudad;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoblacionHombre() {
		return poblacionHombre;
	}

	public void setPoblacionHombre(int poblacionHombre) {
		this.poblacionHombre = poblacionHombre;
	}

	public int getPoblacionMujeres() {
		return poblacionMujeres;
	}

	public void setPoblacionMujeres(int poblacionMujeres) {
		this.poblacionMujeres = poblacionMujeres;
	}

	public int getPoblacionTotal() {
		return poblacionTotal;
	}

	public void setPoblacionTotal(int poblacionTotal) {
		this.poblacionTotal = poblacionTotal;
	}
	
	
}
