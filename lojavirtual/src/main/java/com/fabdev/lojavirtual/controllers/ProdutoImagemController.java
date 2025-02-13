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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fabdev.lojavirtual.entities.ProdutoImagem;
import com.fabdev.lojavirtual.services.ProdutoImagemService;

@RestController
@RequestMapping("/api/produtoImagem")
public class ProdutoImagemController {
	
	@Autowired
	private ProdutoImagemService service;
	
	@GetMapping("/")
	public List<ProdutoImagem> buscarTodas() {
		
		return service.listarTodas();
	}
	
	@PostMapping("/")
	public ProdutoImagem inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file) {
		
		return service.inserir(idProduto, file);
	}
	
	@PutMapping("/")
	public ProdutoImagem alterar(@RequestBody ProdutoImagem produtoImagem) {
		
		return service.alterar(produtoImagem);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
		
		service.excluir(id);
		return ResponseEntity.ok().build();
	}
}
