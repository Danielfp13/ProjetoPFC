package com.projeto.helpapet.dto;

import java.io.Serializable;
import java.util.Date;

import com.projeto.helpapet.domain.Instituicao;
import com.projeto.helpapet.services.validation.AnimalInsert;

@AnimalInsert
public class AnimalNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Instituicao idInstituicaoFk;
	private String idMicrochip;
	private String nome;
	private String porte;
	private String genero;
	private String vacinado;
	private Date anoNascimento;
	private String raca;
	private String vermifugado;
	private String especie;
	private Date dataRecolhimento;
	private String esterelizado;
	private String cor;
	private String descricao;

	public AnimalNewDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instituicao getIdInstituicaoFk() {
		return idInstituicaoFk;
	}

	public void setIdInstituicaoFk(Instituicao idInstituicaoFk) {
		this.idInstituicaoFk = idInstituicaoFk;
	}

	public String getIdMicrochip() {
		return idMicrochip;
	}

	public void setIdMicrochip(String idMicrochip) {
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

}
