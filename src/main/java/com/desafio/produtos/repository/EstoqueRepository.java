package com.desafio.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.desafio.produtos.models.Estoque;

public interface EstoqueRepository extends PagingAndSortingRepository<Estoque, Long>, JpaSpecificationExecutor<Estoque> {

	List<Estoque> findById(String nome);
	

}
