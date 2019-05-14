package com.projeto.helpapet.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.projeto.helpapet.services.validation.AdotanteInsert;

@AdotanteInsert
public class AdotanteNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5,max=80,message="o Tamaho deve ser entre 5 e 80 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	private Date dataAtualizacao;
	private Date dataCadastro;
	@Check(constraints = "situacao IN('Ativo','Inativo')")
	private String situacao;
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	@NotEmpty(message="Preenchimento obrigatório")
	private String municipio;
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	@AssertTrue(message="Tem que aceitar o termo de uso")
	@Column(name = "termo", columnDefinition = "Boolean")
	private Boolean termo;
	
	public Boolean getTermo() {
		return termo;
	}

	public void setTermo(Boolean termo) {
		this.termo = termo;
	}

	@NotEmpty(message="Preenchimento obrigatório")
	private String uf;
	@NotEmpty(message="Preenchimento obrigatório")
	private String bairro;
	@NotEmpty(message="Preenchimento obrigatório")
	private String rua;
	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;
	private String foto;
	@NotEmpty(message="Preenchimento obrigatório")
	@CPF(message="CPF incorreto")
	private String cpf;
	@NotEmpty(message="Preenchimento obrigatório")
	private String rg;
	private Date dataNascimento;
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1;
	private String telefone2;

	public AdotanteNewDTO() {

	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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


	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
}
