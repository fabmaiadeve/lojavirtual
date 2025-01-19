package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Categoria;
import com.fabdev.lojavirtual.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository rep;
	
	public List<Categoria> listarTodas() {
		
		return rep.findAll();
	}
	
	public Categoria inserir(Categoria categoria) {
		
		categoria.setDataCriacao(new Date());
		Categoria categoriaNova = rep.saveAndFlush(categoria);
		return categoriaNova;
	}
	
	public Categoria alterar(Categoria categoria) {
		
		categoria.setDataAtualizacao(new Date());
		return rep.saveAndFlush(categoria);
	}
	
	public void excluir(Long id) {
		
		Categoria categoria = rep.findById(id).get();
		rep.delete(categoria);		
	}
}
