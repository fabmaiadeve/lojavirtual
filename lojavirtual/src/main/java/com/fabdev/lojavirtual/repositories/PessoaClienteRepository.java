package com.fabdev.lojavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabdev.lojavirtual.entities.Pessoa;

@Repository
public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
}
