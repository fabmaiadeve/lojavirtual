package com.fabdev.lojavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabdev.lojavirtual.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
