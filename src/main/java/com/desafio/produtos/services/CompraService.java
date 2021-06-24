package com.desafio.produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.produtos.controller.dao.CompraDao;
import com.desafio.produtos.models.Compra;
import com.desafio.produtos.repository.CompraRepository;
import com.desafio.produtos.repository.EstoqueRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public List<Compra> listar() {
		return compraRepository.findAll();
	}
	
	public Compra adicionar(Compra compra) {
		CompraDao.updateProduto(estoqueRepository, compra);
		Compra compraSalva = compraRepository.save(compra);
		for (com.desafio.produtos.models.ItensComprados itensCompra : compra.getItensComprados()) {
			itensCompra.setCompra(compraSalva);
			CompraRepository.save(itensCompra);
	}
		return compraRepository.save(compra);
	}


}
