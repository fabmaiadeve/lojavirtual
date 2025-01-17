package com.fabdev.lojavirtual.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String sigla;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtuaizacao;	
	
	public Estado() {
	}

	public Estado(String nome, String sigla, Date dataCriacao, Date dataAtuaizacao) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.dataCriacao = dataCriacao;
		this.dataAtuaizacao = dataAtuaizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtuaizacao() {
		return dataAtuaizacao;
	}

	public void setDataAtuaizacao(Date dataAtuaizacao) {
		this.dataAtuaizacao = dataAtuaizacao;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", dataCriacao=" + dataCriacao
				+ ", dataAtuaizacao=" + dataAtuaizacao + "]";
	}

}
