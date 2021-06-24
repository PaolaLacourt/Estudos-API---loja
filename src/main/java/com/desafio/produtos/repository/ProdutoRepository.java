package com.desafio.produtos.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.desafio.produtos.models.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {


}
