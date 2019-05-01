package com.projeto.helpapet.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ArquivoAnimal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
	@JoinColumn(name = "id_animal_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
    private Animal animal;
	
	
    @Lob
    private byte[] foto;
    
    public ArquivoAnimal() {
    	
    }


	public ArquivoAnimal(int id, Animal animal, byte[] foto) {
		super();
		this.id = id;
		this.animal = animal;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
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

