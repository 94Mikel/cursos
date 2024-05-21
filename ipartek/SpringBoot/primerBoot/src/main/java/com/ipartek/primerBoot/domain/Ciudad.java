package com.ipartek.primerBoot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class Ciudad {
	
		@Id
		@Column(name="ID")
		private int id;
		
		@Column(name="Name")
		private String nombre;
		
		@ManyToOne
	    @JoinColumn(name ="Countrycode")
		private String codigoPais;
		
		@Column(name="District")
		private String distrito;
		
		@Column(name="Population")
		private int populacion;
		
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCodigoPais() {
			return codigoPais;
		}

		public void setCodigoPais(String codigoPais) {
			this.codigoPais = codigoPais;
		}

		public String getDistrito() {
			return distrito;
		}

		public void setDistrito(String distrito) {
			this.distrito = distrito;
		}

		public int getPopulacion() {
			return populacion;
		}

		public void setPopulacion(int populacion) {
			this.populacion = populacion;
		}
}
