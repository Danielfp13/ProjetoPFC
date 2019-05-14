package com.projeto.helpapet.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.projeto.helpapet.domain.Animal;

public class AnimalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5,max=80,message="o Tamaho deve ser entre 5 e 80 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento obrigatório")
	private String especie;

	public AnimalDTO() {

	}

	public AnimalDTO(Animal obj) {
		id= obj.getId();
		nome = obj.getNome();
		especie = obj.getEspecie();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
}
