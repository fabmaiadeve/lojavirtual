package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.dtos.PessoaClienteRequestDto;
import com.fabdev.lojavirtual.entities.Pessoa;
import com.fabdev.lojavirtual.repositories.PermissaoRepository;
import com.fabdev.lojavirtual.repositories.PessoaClienteRepository;

@Service
public class PessoaClienteService {
	
	@Autowired
	private PessoaClienteRepository rep;
	
	@Autowired
	private PermissaoPessoaService permissaoPessoaService;
	
	@Autowired
	private EmailService emailService;
	
	public Pessoa registrar(PessoaClienteRequestDto dto) {
		
		Pessoa pessoa = dto.converter(dto);
		
		pessoa.setDataCriacao(new Date());
		Pessoa pessoaNova = rep.saveAndFlush(pessoa);
		
		permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
		
		//emailService.enviarEmailTexto(pessoaNova.getEmail(), "Cadastro na loja virtual", "O registro na loja foi realizado com sucesso!");
		Map<String, Object> propMap = new HashMap<>();
		propMap.put("nome", pessoaNova.getNome());
		propMap.put("mensagem", "O registro na loja foi realizado com sucesso!");
		
		emailService.enviarEmailTemplate(pessoaNova.getEmail(), "Cadastro na loja virtual", propMap);
		
		return pessoaNova;
	}
}
