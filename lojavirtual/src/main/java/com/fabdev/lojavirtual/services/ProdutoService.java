package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Produto;
import com.fabdev.lojavirtual.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository rep;
	
	public List<Produto> listarTodas() {
		
		return rep.findAll();
	}
	
	public Produto inserir(Produto produto) {
		
		produto.setDataCriacao(new Date());
		Produto produtoNovo = rep.saveAndFlush(produto);
		return produtoNovo;
	}
	
	public Produto alterar(Produto produto) {
		
		produto.setDataAtualizacao(new Date());
		return rep.saveAndFlush(produto);
	}
	
	public void excluir(Long id) {
		
		Produto produto = rep.findById(id).get();
		rep.delete(produto);
	}
}
