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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JoinColumn(name = "id_instituicao_fk", referencedColumnName = "idusuario")
	@ManyToOne(optional = false)
	private Usuario idInstituicaoFk;
	@NotBlank
	private Integer idMicrochip;
	private String nome;
	private String porte;
	private String genero;
	private String vacinado;
	@Column(name = "dataRecolhimento", columnDefinition = "DATE")
	private Date anoNascimento;
	private String raca;
	private String vermifugado;
	private String especie;
	
	@Column(name = "data_de_Recolhimento",columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataRecolhimento;
	private String esterelizado;
	private String cor;
	private String descricao;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnimal")
	// private Set<ArquivoAnimal> arquivoAnimalSet;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnimalFk")
	// private Set<Adocao> adocaoSet;

	public Animal() {

	}

	public Animal(int id, Usuario idInstituicaoFk, Integer idMicrochip, String nome, String porte, String genero,
			String vacinado, Date anoNascimento, String raca, String vermifugado, String especie, Date dataRecolhimento,
			String esterelizado, String cor, String descricao) {
		super();
		this.id = id;
		this.idInstituicaoFk = idInstituicaoFk;
		this.idMicrochip = idMicrochip;
		this.nome = nome;
		this.porte = porte;
		this.genero = genero;
		this.vacinado = vacinado;
		this.anoNascimento = anoNascimento;
		this.raca = raca;
		this.vermifugado = vermifugado;
		this.especie = especie;
		this.dataRecolhimento = dataRecolhimento;
		this.esterelizado = esterelizado;
		this.cor = cor;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getIdInstituicaoFk() {
		return idInstituicaoFk;
	}

	public void setIdInstituicaoFk(Usuario idInstituicaoFk) {
		this.idInstituicaoFk = idInstituicaoFk;
	}

	public Integer getIdMicrochip() {
		return idMicrochip;
	}

	public void setIdMicrochip(Integer idMicrochip) {
		this.idMicrochip = idMicrochip;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getVacinado() {
		return vacinado;
	}

	public void setVacinado(String vacinado) {
		this.vacinado = vacinado;
	}

	public Date getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(Date anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getVermifugado() {
		return vermifugado;
	}

	public void setVermifugado(String vermifugado) {
		this.vermifugado = vermifugado;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Date getDataRecolhimento() {
		return dataRecolhimento;
	}

	public void setDataRecolhimento(Date dataRecolhimento) {
		this.dataRecolhimento = dataRecolhimento;
	}

	public String getEsterelizado() {
		return esterelizado;
	}

	public void setEsterelizado(String esterelizado) {
		this.esterelizado = esterelizado;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Animal other = (Animal) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
