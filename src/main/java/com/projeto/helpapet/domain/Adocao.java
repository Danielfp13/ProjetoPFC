package com.projeto.helpapet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Adocao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JoinColumn(name = "id_animal_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Animal idAnimalFk;
	
	@JoinColumn(name = "id_adotante_fk", referencedColumnName = "idusuario")
	@ManyToOne(optional = false)
	private Usuario idAdotanteFk;
	
	@Column(name = "dataInicio", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	
	@Column(name = "dataTermino", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataTermino;
	private String status;

	public Adocao() {
	}

	public Adocao(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Animal getIdAnimalFk() {
		return idAnimalFk;
	}

	public void setIdAnimalFk(Animal idAnimalFk) {
		this.idAnimalFk = idAnimalFk;
	}

	public Usuario getIdAdotanteFk() {
		return idAdotanteFk;
	}

	public void setIdAdotanteFk(Usuario idAdotanteFk) {
		this.idAdotanteFk = idAdotanteFk;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Adocao other = (Adocao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
