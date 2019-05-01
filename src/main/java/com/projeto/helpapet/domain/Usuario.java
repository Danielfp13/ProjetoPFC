package com.projeto.helpapet.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nome;
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "dataAtua", columnDefinition = "DATE")
	private Date dataAtualizacao;

	@Column(name = "dataCadastro", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCadastro;
	private String situacao;
	private String senha;
	private String municipio;
	private String cep;
	private String uf;
	private String bairro;
	private String rua;
	private String numero;
	private byte[] foto;
	private String tipo;
	private String cpf;
	private String rg;

	@Column(name = "dataNascimento", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataNascimento;
	private String cnpj;
	private String situacaoDeAprovacao;
	private String descricaoInstituicao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
	private Set<Telefone> listTelefones = new HashSet<Telefone>();

	public Usuario() {

	}

	public Usuario(Integer idUsuario, String nome, String email, Date dataAtualizacao, Date dataCadastro,
			String situacao, String senha, String municipio, String cep, String uf, String bairro, String rua,
			String numero, byte[] foto, String tipo, String cpf, String rg, Date dataNascimento, String cnpj,
			String situacaoDeAprovacao, String descricaoInstituicao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.dataAtualizacao = dataAtualizacao;
		this.dataCadastro = dataCadastro;
		this.situacao = situacao;
		this.senha = senha;
		this.municipio = municipio;
		this.cep = cep;
		this.uf = uf;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.foto = foto;
		this.tipo = tipo;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.cnpj = cnpj;
		this.situacaoDeAprovacao = situacaoDeAprovacao;
		this.descricaoInstituicao = descricaoInstituicao;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSituacaoDeAprovacao() {
		return situacaoDeAprovacao;
	}

	public void setSituacaoDeAprovacao(String situacaoDeAprovacao) {
		this.situacaoDeAprovacao = situacaoDeAprovacao;
	}

	public String getDescricaoInstituicao() {
		return descricaoInstituicao;
	}

	public void setDescricaoInstituicao(String descricaoInstituicao) {
		this.descricaoInstituicao = descricaoInstituicao;
	}

	public Set<Telefone> getListTelefones() {
		return listTelefones;
	}

	public void setListTelefones(Set<Telefone> listTelefones) {
		this.listTelefones = listTelefones;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}

