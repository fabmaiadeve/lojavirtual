package com.fabdev.lojavirtual.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "permissao_pessoa")
public class PermissaoPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	@JsonIgnore
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_permissao")
	private Permissao permissao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;

	
	public PermissaoPessoa() {
	}

	public PermissaoPessoa(Pessoa pessoa, Permissao permissao, Date dataCriacao, Date dataAtualizacao) {
		this.pessoa = pessoa;
		this.permissao = permissao;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
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

	@Override
	public String toString() {
		return "PermissaoPessoa [id=" + id + ", pessoa=" + pessoa + ", permissao=" + permissao + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
}
