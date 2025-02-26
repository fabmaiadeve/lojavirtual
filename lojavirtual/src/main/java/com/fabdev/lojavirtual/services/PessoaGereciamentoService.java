package com.fabdev.lojavirtual.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Pessoa;
import com.fabdev.lojavirtual.repositories.PessoaRepository;

@Service
public class PessoaGereciamentoService {
	
	@Autowired
	private PessoaRepository rep;
	
	
	
	@Autowired
	private EmailService emailService;
	
	public String solicitarCodigo(String email) {
		
		Pessoa pessoa = rep.findByEmail(email);
		pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
		pessoa.setDataEnvioCodigo(new Date());
		
		rep.saveAndFlush(pessoa);
		emailService.enviarEmailTexto(pessoa.getEmail(), "Código de Recuperação de senha", "Olá, o seu código para recuperação de senha é o seguinte: " + pessoa.getCodigoRecuperacaoSenha());
		
		return "Código enviado";
	}
	
	public String alterarSenha(Pessoa pessoa) {
		
		Pessoa pessoaBanco = rep.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
		
		if(pessoaBanco != null) {
			Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());
			
			if(diferenca.getTime() / 1000 < 900) {
				pessoaBanco.setSenha(pessoa.getSenha());
				pessoaBanco.setCodigoRecuperacaoSenha(null);
				
				rep.saveAndFlush(pessoaBanco);
				
				return "Senha alterada com sucesso!";
			} else {
				return "Tempo expirado! Solicite um novo código!";
			}
		} else {
			return "Email ou código não encontrado.";
		}
	}
	
	private String getCodigoRecuperacaoSenha(Long id) {
		
		DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");		
		return format.format(new Date()) + id;		
	}
}
