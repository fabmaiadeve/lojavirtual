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

import com.fabdev.lojavirtual.entities.Marca;
import com.fabdev.lojavirtual.services.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService service;
	
	@GetMapping("/")
	public List<Marca> buscarTodas() {
		
		return service.listarTodas();
	}
	
	@PostMapping("/")
	public Marca inserir(@RequestBody Marca marca) {
		
		return service.inserir(marca);
	}
	
	@PutMapping("/")
	public Marca alterar(@RequestBody Marca marca) {
		
		return service.alterar(marca);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
		
		service.excluir(id);
		return ResponseEntity.ok().build();
	}
}
