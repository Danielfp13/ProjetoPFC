package com.projeto.helpapet.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Check(constraints = "situacao IN('Ativo','Inativo')")
public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_usuario", columnDefinition = "integer")
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idUsuario;
	
	@NotNull
	@Column(name = "nome", columnDefinition = "varchar(100)")
	private String nome;
	
	@AssertTrue(message="Tem que aceitar o termo de uso")
	@NotNull
	@Column(name = "termo", columnDefinition = "Boolean")
	private Boolean termo; 
	
	@NotNull
	@Column(name = "email",unique=true, columnDefinition = "varchar(100)")
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_atualizacao", columnDefinition = "DATE")
	private Date dataAtualizacao;
	
	public Boolean getTermo() {
		return termo;
	}

	public void setTermo(Boolean termo) {
		this.termo = termo;
	}

	@Column(name = "data_cadastro", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;

	@NotNull
	@Column(name = "situacao",columnDefinition = "varchar(8)")
	private String situacao;
	
	@NotNull
	@Column(name = "senha",columnDefinition = "varchar(15)")
	private String senha;
	
	@NotNull
	@Column(name = "municipio",columnDefinition = "varchar(100)")
	private String municipio;
	
	@NotNull
	@Column(name = "cep",columnDefinition = "varchar(9)")
	private String cep;
	
	
	@NotNull
	@Column(name = "uf",columnDefinition = "varchar(2)")
	private String uf;
	
	@NotNull
	@Column(name = "bairro",columnDefinition = "varchar(60)")
	private String bairro;
	
	@NotNull
	@Column(name = "rua",columnDefinition = "varchar(100)")
	private String rua;
	
	@NotNull
	@Column(name = "numero",columnDefinition = "varchar(5)")	
	private String numero;
	
	@Column(name = "foto",columnDefinition = "varchar(150)")
	private String foto;
	
	@UniqueElements
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	public Usuario() {

	}

	public Usuario(Integer idUsuario, String nome, String email, Date dataAtualizacao, Date dataCadastro,
			String situacao, String senha, String municipio, String cep, String uf, String bairro, String rua,
			String numero, String foto, Boolean termo) {
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
		this.termo = termo;

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

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
}
