package com.fabdev.lojavirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabdev.lojavirtual.entities.Produto;
import com.fabdev.lojavirtual.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/")
	public List<Produto> buscarTodas() {
		
		return service.listarTodas();
	}
	
	@PostMapping("/")
	public Produto inserir(@RequestBody Produto produto) {
		
		return service.inserir(produto);
	}
	
	@PutMapping("/")
	public Produto alterar(@RequestBody Produto produto) {
		
		return service.alterar(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
		
		service.excluir(id);
		return ResponseEntity.ok().build();
	}	
}
