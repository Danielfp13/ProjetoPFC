package com.projeto.helpapet.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Adotante extends Usuario {

	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(name = "cpf", columnDefinition = "varchar(11)", unique = true)
	private String cpf;

	@NotNull
	@Column(name = "rg", columnDefinition = "varchar(11)", unique = true)
	private String rg;

	@NotNull
	@Column(name = "dataNascimento", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataNascimento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdotanteFk")
	private Set<Adocao> listAdocao = new HashSet<Adocao>();

	public Adotante() {

	}

	public Adotante(Integer idUsuario, String nome, String email, Date dataAtualizacao, Date dataCadastro,
			String situacao, String senha, String municipio, String cep, String uf, String bairro, String rua,
			String numero, String foto, String cpf, String rg, Date dataNascimento,Boolean termo) {
		super(idUsuario, nome, email, dataAtualizacao, dataCadastro, situacao, senha, municipio, cep, uf, bairro, rua,
				numero, foto,termo);
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Adocao> getListAdocao() {
		return listAdocao;
	}

	public void setListAdocao(Set<Adocao> listAdocao) {
		this.listAdocao = listAdocao;
	}

}
