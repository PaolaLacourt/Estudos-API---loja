package com.desafio.produtos.controller.dao;

import java.util.List;

import com.desafio.produtos.models.Estoque;
import com.desafio.produtos.models.ItensVendidos;
import com.desafio.produtos.models.Venda;
import com.desafio.produtos.repository.EstoqueRepository;

public class VendaDao {
	
	public static void updateProduto(EstoqueRepository estoqueRepository, Venda venda) {
		for (ItensVendidos itensVenda : venda.getItensVendidos()) {
			List<Estoque> estoque = estoqueRepository.findById(itensVenda.getProduto().getNome());
			for (Estoque newEstoque : estoque) {

				newEstoque.diminuiEstoque(itensVenda.getQuantidade());

			}
		}
	}

}
