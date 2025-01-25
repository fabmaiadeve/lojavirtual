package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Pessoa;
import com.fabdev.lojavirtual.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository rep;
	
	public List<Pessoa> listarTodas() {
		
		return rep.findAll();
	}	
	
	public Pessoa inserir(Pessoa pessoa) {
		
		pessoa.setDataCriacao(new Date());
		Pessoa pessoaNova = rep.saveAndFlush(pessoa);
		return pessoaNova;
	}
	
	public Pessoa alterar(Pessoa pessoa) {
		
		pessoa.setDataAtualizacao(new Date());
		return rep.saveAndFlush(pessoa);
	}
	
	public void excluir(Long id) {
		
		Pessoa pessoa = rep.findById(id).get();
		rep.delete(pessoa);
	}
}
