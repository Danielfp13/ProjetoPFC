package com.projeto.helpapet.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Check;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Check(constraints = "situacao_de_aprovacao IN('Pendente','Aprovado','Reprovado')")
public class Instituicao extends Usuario {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "cnpj", columnDefinition = "varchar(15)", unique = true)
	private String cnpj;

	@NotNull
	@Column(name = "situacao_de_aprovacao", columnDefinition = "varchar(10)")
	private String situacaoDeAprovacao;

	@Column(name = "descricao_instituicao", columnDefinition = "TEXT")
	private String descricaoInstituicao;

	@JsonIgnore
	@OneToMany(mappedBy = "instituicao")
	private Set<Animal> animais = new HashSet<Animal>();

	public Instituicao() {

	}

	public Instituicao(Integer idUsuario, String nome, String email, Date dataAtualizacao, Date dataCadastro,
			String situacao, String senha, String municipio, String cep, String uf, String bairro, String rua,
			String numero, String foto, String cnpj, String situacaoDeAprovacao, String descricaoInstituicao,
			Boolean termo) {
		super(idUsuario, nome, email, dataAtualizacao, dataCadastro, situacao, senha, municipio, cep, uf, bairro, rua,
				numero, foto,termo);
		this.cnpj = cnpj;
		this.situacaoDeAprovacao = situacaoDeAprovacao;
		this.descricaoInstituicao = descricaoInstituicao;
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

	public Set<Animal> getAnimals() {
		return animais;
	}

	public void setAnimals(Set<Animal> animais) {
		this.animais = animais;
	}

}
