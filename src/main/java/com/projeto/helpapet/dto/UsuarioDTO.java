package com.projeto.helpapet.dto;

import java.io.Serializable;
import java.util.Date;

import com.projeto.helpapet.domain.Usuario;


public class UsuarioDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String nome;
	private String email;
	private Date dataAtualizacao;
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
	private Date dataNascimento;
	private String cnpj;
	private String situacaoDeAprovacao;
	private String descricaoInstituicao;

	public UsuarioDTO() {

	}

	public UsuarioDTO(Usuario obj) {
		idUsuario = obj.getIdUsuario();
		nome = obj.getNome();
		email = obj.getEmail();
		dataAtualizacao = obj.getDataAtualizacao();
		dataCadastro = obj.getDataCadastro();
		situacao = obj.getSituacao();
		senha = obj.getSenha();
		municipio = obj.getMunicipio();
		cep = obj.getCep();
		uf = obj.getUf();
		bairro = obj.getBairro();
		rua = obj.getRua();
		numero = obj.getNumero();
		foto = obj.getFoto();
		tipo = obj.getTipo();
		cpf = obj.getCpf();
		rg = obj.getRg();
		dataNascimento = obj.getDataNascimento();
		cnpj = obj.getCnpj();
		situacaoDeAprovacao = obj.getSituacaoDeAprovacao();
		descricaoInstituicao = obj.getDescricaoInstituicao();

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
}
