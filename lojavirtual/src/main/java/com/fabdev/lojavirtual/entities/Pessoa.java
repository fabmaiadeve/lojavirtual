package com.fabdev.lojavirtual.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String email;
	
	private String codigoRecuperacaoSenha;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvioCodigo;
	
	private String senha;
	
	private String endereco;
	
	private String cep;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<PermissaoPessoa> permissaoPessoas;

	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String email, String codigoRecuperacaoSenha, Date dataEnvioCodigo, String senha, String endereco, String cep, Date dataCriacao,
			Date dataAtualizacao, Cidade cidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.codigoRecuperacaoSenha = codigoRecuperacaoSenha;
		this.dataEnvioCodigo = dataEnvioCodigo;
		this.senha = senha;
		this.endereco = endereco;
		this.cep = cep;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.cidade = cidade;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCodigoRecuperacaoSenha() {
		return codigoRecuperacaoSenha;
	}

	public void setCodigoRecuperacaoSenha(String codigoRecuperacaoSenha) {
		this.codigoRecuperacaoSenha = codigoRecuperacaoSenha;
	}
	
	public Date getDataEnvioCodigo() {
		return dataEnvioCodigo;
	}

	public void setDataEnvioCodigo(Date dataEnvioCodigo) {
		this.dataEnvioCodigo = dataEnvioCodigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}	

	public List<PermissaoPessoa> getPermissaoPessoas() {
		return permissaoPessoas;
	}

	public void setPermissaoPessoas(List<PermissaoPessoa> permissaoPessoas) {
		for(PermissaoPessoa p : permissaoPessoas) {
			p.setPessoa(this);
		}
		this.permissaoPessoas = permissaoPessoas;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", codigoRecuperacaoSenha="
				+ codigoRecuperacaoSenha + ", dataEnvioCodigo=" + dataEnvioCodigo + ", senha=" + senha
				+ ", endereco=" + endereco + ", cep=" + cep + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", cidade=" + cidade + ", permissaoPessoas=" + permissaoPessoas + "]";
	}
}
