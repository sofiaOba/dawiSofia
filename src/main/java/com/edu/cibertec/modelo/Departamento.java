package com.edu.cibertec.modelo;

import java.io.Serializable;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//nombre la table tal como esta en MYSQL
//serializable 0 y 1
@Entity
@Table(name="departamentos")
public class Departamento implements Serializable {

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_depa;
	private String nombre;
	
	
	
	
	//constructores
	public Departamento() {
		
	}



	public Departamento(int id_depa, String nombre) {
		 
		this.id_depa = id_depa;
		this.nombre = nombre;
	}
	
	
	//set y get
	public int getId_depa() {
		return id_depa;
	}
	public void setId_depa(int id_depa) {
		this.id_depa = id_depa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
}//fin
