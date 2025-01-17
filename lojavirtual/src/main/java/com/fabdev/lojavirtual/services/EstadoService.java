package com.fabdev.lojavirtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabdev.lojavirtual.entities.Estado;
import com.fabdev.lojavirtual.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository rep;

	public List<Estado> listarTodos() {

		return rep.findAll();
	}

	public Estado inserir(Estado estado) {

		estado.setDataCriacao(new Date());
		Estado estadoNovo = rep.saveAndFlush(estado);
		return estadoNovo;
	}

	public Estado alterar(Estado estado) {

		estado.setDataAtuaizacao(new Date());
		return rep.saveAndFlush(estado);
	}

	public void excluir(Long id) {

		Estado estado = rep.findById(id).get();
		rep.delete(estado);
	}
}
