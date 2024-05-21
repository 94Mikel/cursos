package com.ipartek.primerBoot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@Entity
	@Table(name="country")
	public class Pais {
		
		@Id
		@Column(name="Code")
		private String idPais;
		
		@Column(name="Name")
		private String nombre;
		
		@Column(name="Continent")
		private String continente;
		
		@Column(name="Region")
		private String region;
		
		@OneToMany(mappedBy = "codigoPais")
		List<Ciudad> ciudades;
		
		
		public List<Ciudad> getCiudades() {
			return ciudades;
		}

		public void setCiudades(List<Ciudad> ciudades) {
			this.ciudades = ciudades;
		}

		public String getIdPais() {
			return idPais;
		}

		public void setIdPais(String idPais) {
			this.idPais = idPais;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getContinente() {
			return continente;
		}

		public void setContinente(String continente) {
			this.continente = continente;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}
	
}
