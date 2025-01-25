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
@Table(name = "produto") 
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricaoCurta;
	
	private String descricaoDetalhada;
	
	private Double valorCusto;
	
	private Double valorVenda;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;

	
	public Produto() {
	}

	public Produto(String descricaoCurta, String descricaoDetalhada, Double valorCusto, Double valorVenda,
			Date dataCriacao, Date dataAtualizacao, Categoria categoria, Marca marca) {
		this.descricaoCurta = descricaoCurta;
		this.descricaoDetalhada = descricaoDetalhada;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.categoria = categoria;
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoCurta() {
		return descricaoCurta;
	}

	public void setDescricaoCurta(String descricaoCurta) {
		this.descricaoCurta = descricaoCurta;
	}

	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}

	public void setDescricaoDetalhada(String descricaoDetalhada) {
		this.descricaoDetalhada = descricaoDetalhada;
	}

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricaoCurta=" + descricaoCurta + ", descricaoDetalhada=" + descricaoDetalhada
				+ ", valorCusto=" + valorCusto + ", valorVenda=" + valorVenda + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", categoria=" + categoria + ", marca=" + marca + "]";
	}
}
