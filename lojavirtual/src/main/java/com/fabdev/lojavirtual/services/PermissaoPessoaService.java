package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Permissao;
import com.fabdev.lojavirtual.entities.PermissaoPessoa;
import com.fabdev.lojavirtual.entities.Pessoa;
import com.fabdev.lojavirtual.repositories.PermissaoPessoaRepository;
import com.fabdev.lojavirtual.repositories.PermissaoRepository;

@Service
public class PermissaoPessoaService {

	@Autowired
	private PermissaoPessoaRepository rep;
	
	@Autowired
	private PermissaoRepository repPermissao;

	
	public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
		
		List<Permissao> listaPermissao = repPermissao.findByNome("Cliente");
		
		if(listaPermissao.size() > 0) {
			
			PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
			permissaoPessoa.setPessoa(pessoa);
			permissaoPessoa.setPermissao(listaPermissao.get(0));
			permissaoPessoa.setDataCriacao(new Date());
			rep.saveAndFlush(permissaoPessoa);
		}		
	}
}
