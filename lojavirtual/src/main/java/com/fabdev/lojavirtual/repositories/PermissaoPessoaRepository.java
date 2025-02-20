package com.fabdev.lojavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabdev.lojavirtual.entities.PermissaoPessoa;

@Repository
public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa, Long> {
}
