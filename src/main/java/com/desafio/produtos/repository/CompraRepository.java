package com.desafio.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.produtos.models.Compra;
import com.desafio.produtos.models.ItensComprados;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	static void save(ItensComprados itensCompra) {
		
	}

}
