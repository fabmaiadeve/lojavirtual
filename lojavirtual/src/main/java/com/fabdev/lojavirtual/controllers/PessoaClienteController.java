package com.fabdev.lojavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabdev.lojavirtual.dtos.PessoaClienteRequestDto;
import com.fabdev.lojavirtual.entities.Pessoa;
import com.fabdev.lojavirtual.services.PessoaClienteService;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {
	
	@Autowired
	private PessoaClienteService service;
	
		
	@PostMapping("/")
	public Pessoa inserir(@RequestBody PessoaClienteRequestDto dto) {		
		
		return service.registrar(dto);
	}	
}
