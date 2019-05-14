package com.projeto.helpapet.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotNull
	@Column(name = "id_Microchip", columnDefinition = "varchar(50)", unique = true)
	private String idMicrochip;

	@NotNull
	@Column(name = "nome", columnDefinition = "varchar(100)")
	private String nome;

	@NotNull
	@Column(name = "porte", columnDefinition = "varchar(8)")
	private String porte;

	@NotNull
	@Column(name = "genero", columnDefinition = "varchar(6)")
	private String genero;

	@NotNull
	@Column(name = "vacinado", columnDefinition = "varchar(3)")
	private String vacinado;

	@Column(name = "ano_nascimento", columnDefinition = "DATE")
	private Date anoNascimento;

	@NotNull
	@Column(name = "raca", columnDefinition = "varchar(30)")
	private String raca;

	@NotNull
	@Column(name = "vermifugado", columnDefinition = "varchar(3)")
	private String vermifugado;

	@NotNull
	@Column(name = "especie", columnDefinition = "varchar(30)")
	private String especie;

	@NotNull
	@Column(name = "data_de_Recolhimento", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataRecolhimento;

	@NotNull
	@Column(name = "esterelizado", columnDefinition = "varchar(3)")
	private String esterelizado;

	@NotNull
	@Column(name = "cor", columnDefinition = "varchar(30)")
	private String cor;

	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;

	@JsonIgnore
	@OneToMany(mappedBy = "idAnimalFk")
	private Set<ArquivoAnimal> arquivoAnimalSet = new HashSet<>();
	@JsonIgnore
	@OneToMany( mappedBy = "idAnimalFk")
	private Set<Adocao> adocaoSet= new HashSet<Adocao>();

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_instituicao_fk", referencedColumnName = "id_usuario")
	private Instituicao instituicao;

	public Animal() {

	}

	public Animal(Integer id, Instituicao instituicao, String idMicrochip, String nome, String porte, String genero,
			String vacinado, Date anoNascimento, String raca, String vermifugado, String especie, Date dataRecolhimento,
			String esterelizado, String cor, String descricao) {
		super();
		this.id = id;
		this.instituicao = instituicao;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
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

	public Set<Adocao> getAdocaoSet() {
		return adocaoSet;
	}

	public void setAdocaoSet(Set<Adocao> adocaoSet) {
		this.adocaoSet = adocaoSet;
	}

	public Set<ArquivoAnimal> getArquivoAnimalSet() {
		return arquivoAnimalSet;
	}

	public void setArquivoAnimalSet(Set<ArquivoAnimal> arquivoAnimalSet) {
		this.arquivoAnimalSet = arquivoAnimalSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
