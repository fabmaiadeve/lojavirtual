package com.fabdev.lojavirtual.services;

import java.util.Date;

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
	
	public Pessoa registrar(PessoaClienteRequestDto dto) {
		
		Pessoa pessoa = dto.converter(dto);
		
		pessoa.setDataCriacao(new Date());
		Pessoa pessoaNova = rep.saveAndFlush(pessoa);
		
		permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
		
		return pessoaNova;
	}
}
