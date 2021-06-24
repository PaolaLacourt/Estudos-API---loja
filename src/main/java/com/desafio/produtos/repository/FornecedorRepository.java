package com.desafio.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.produtos.models.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {


}
