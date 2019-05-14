package com.projeto.helpapet.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ArquivoAnimal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
	
	@JoinColumn(name = "id_Animal_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
    private Animal idAnimalFk;
	
	
	@Column(name = "foto", columnDefinition = "varchar(150)")
    private String foto;
    
    public ArquivoAnimal() {
    	
    }


	public ArquivoAnimal(int id, Animal idAnimalFk, String foto) {
		super();
		this.id = id;
		this.idAnimalFk = idAnimalFk;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return idAnimalFk;
	}

	public void setAnimal(Animal idAnimalFk) {
		this.idAnimalFk = idAnimalFk;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArquivoAnimal other = (ArquivoAnimal) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
    
}

