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

import com.fabdev.lojavirtual.entities.Cidade;
import com.fabdev.lojavirtual.services.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService service;
	
	@GetMapping("/")
	public List<Cidade> buscarTodas() {
		
		return service.listarTodas();
	}
	
	@PostMapping("/")
	public Cidade inserir(@RequestBody Cidade cidade) {
		
		return service.inserir(cidade);
	}
	
	@PutMapping("/")
	public Cidade alterar(@RequestBody Cidade cidade) {
		
		return service.alterar(cidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
		
		service.excluir(id);
		return ResponseEntity.ok().build();
	}
}
