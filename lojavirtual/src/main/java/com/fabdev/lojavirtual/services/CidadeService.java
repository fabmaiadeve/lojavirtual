package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Cidade;
import com.fabdev.lojavirtual.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository rep;
	
	public List<Cidade> listarTodas() {
		
		return rep.findAll();
	}
	
	public Cidade inserir(Cidade cidade) {
		
		cidade.setDataCriacao(new Date());
		Cidade cidadeNova = rep.saveAndFlush(cidade);
		return cidadeNova;		
	}
	
	public Cidade alterar(Cidade cidade) {
		
		cidade.setDataAtualizacao(new Date());
		return rep.saveAndFlush(cidade);
	}
	
	public void excluir(Long id) {
		
		Cidade cidade = rep.findById(id).get();
		rep.delete(cidade);
	}
}
