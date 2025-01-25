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

import com.fabdev.lojavirtual.entities.Pessoa;
import com.fabdev.lojavirtual.services.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/")
	public List<Pessoa> buscarTodas() {
		
		return service.listarTodas();
	}
	
	@PostMapping("/")
	public Pessoa inserir(@RequestBody Pessoa pessoa) {
		
		return service.inserir(pessoa);
	}
	
	@PutMapping("/")
	public Pessoa alterar(@RequestBody Pessoa pessoa) {
		
		return service.alterar(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
		
		service.excluir(id);
		return ResponseEntity.ok().build();
	}
}
