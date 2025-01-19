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

import com.fabdev.lojavirtual.entities.Categoria;
import com.fabdev.lojavirtual.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/")
	public List<Categoria> buscarTodas() {
		
		return service.listarTodas();
	}
	
	@PostMapping("/")
	public Categoria inserir(@RequestBody Categoria categoria) {
		
		return service.inserir(categoria);
	}
	
	@PutMapping("/")
	public Categoria alterar(@RequestBody Categoria categoria) {
		
		return service.alterar(categoria);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
		
		service.excluir(id);
		return ResponseEntity.ok().build();
	}
}
