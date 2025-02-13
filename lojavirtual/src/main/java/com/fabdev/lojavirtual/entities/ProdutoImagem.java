package com.fabdev.lojavirtual.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "produto_image")
public class ProdutoImagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

		
	public ProdutoImagem() {
	}

	public ProdutoImagem(String nome, Date dataCriacao, Date dataAtualizacao, Produto produto) {
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.produto = produto;
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ProdutoImagem [id=" + id + ", nome=" + nome + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", produto=" + produto + "]";
	}
}
