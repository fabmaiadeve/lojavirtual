package com.fabdev.lojavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabdev.lojavirtual.entities.Pessoa;
import com.fabdev.lojavirtual.services.PessoaGereciamentoService;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {
	
	@Autowired
	private PessoaGereciamentoService service;
	
		
	@PostMapping("/senha-codigo")
	public String recuperarCodigo(@RequestBody Pessoa pessoa) {		
		
		return service.solicitarCodigo(pessoa.getEmail());
	}
	
	@PostMapping("/senha-alterar")
	public String alterarSenha(@RequestBody Pessoa pessoa) {		
		
		return service.alterarSenha(pessoa);
	}
}
