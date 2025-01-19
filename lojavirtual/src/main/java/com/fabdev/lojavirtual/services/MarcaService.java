package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Marca;
import com.fabdev.lojavirtual.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository rep;
	
	public List<Marca> listarTodas() {
		
		return rep.findAll();
	}
	
	public Marca inserir(Marca marca) {
		
		marca.setDataCriacao(new Date());
		Marca marcaNova = rep.saveAndFlush(marca);
		return marcaNova;		
	}
	
	public Marca alterar(Marca marca) {
		
		marca.setDataAtualizacao(new Date());
		return rep.saveAndFlush(marca);		
	}
	
	public void excluir(Long id) {
		
		Marca marca = rep.findById(id).get();
		rep.delete(marca);
	}
}
