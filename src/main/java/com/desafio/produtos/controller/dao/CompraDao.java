package com.desafio.produtos.controller.dao;

import java.util.List;

import com.desafio.produtos.models.Compra;
import com.desafio.produtos.models.Estoque;
import com.desafio.produtos.models.ItensComprados;
import com.desafio.produtos.repository.EstoqueRepository;

public class CompraDao {
	
		public static void updateProduto(EstoqueRepository estoqueRepository, Compra compra) {
			for (ItensComprados itensComprados : compra.getItensComprados()) {
				List<Estoque> estoque = estoqueRepository.findById(itensComprados.getProduto().getNome());
				for (Estoque newEstoque : estoque) {

					newEstoque.somaEstoque(itensComprados.getQuantidade());

				}
			}
		}
	

}
