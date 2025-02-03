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

import com.fabdev.lojavirtual.entities.Permissao;
import com.fabdev.lojavirtual.services.PermissaoService;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {
	
	@Autowired
	private PermissaoService service;
	
	@GetMapping("/")
	public List<Permissao> buscarTodas() {
		
		return service.listarTodas();
	}
	
	@PostMapping("/")
	public Permissao inserir(@RequestBody Permissao permissao) {
		
		return service.inserir(permissao);
	}
	
	@PutMapping("/")
	public Permissao alterar(@RequestBody Permissao permissao) {
		
		return service.alterar(permissao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
		
		service.excluir(id);
		return ResponseEntity.ok().build();
	}
}
