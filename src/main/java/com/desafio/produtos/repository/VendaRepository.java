package com.desafio.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.produtos.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}
