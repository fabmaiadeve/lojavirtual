package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Permissao;
import com.fabdev.lojavirtual.repositories.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository rep;	

	
	public List<Permissao> listarTodas() {
		
		return rep.findAll();
	}
	
	public Permissao inserir(Permissao permissao) {
		
		permissao.setDataCriacao(new Date());
		Permissao permissaoNova = rep.saveAndFlush(permissao);
		return permissaoNova;
	}
	
	public Permissao alterar(Permissao permissao) {
		
		permissao.setDataAtualizacao(new Date());
		return rep.saveAndFlush(permissao);
	}
	
	public void excluir(Long id) {
		
		Permissao permissao = rep.findById(id).get();
		rep.delete(permissao);		
	}
}
