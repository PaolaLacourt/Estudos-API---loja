package com.desafio.produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.produtos.models.Estoque;
import com.desafio.produtos.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public List<Estoque> listar() {
		return (List<Estoque>) estoqueRepository.findAll();
	}
	
	public ResponseEntity<Estoque> update(long idEstoque, Estoque newEstoque)
	{
		java.util.Optional<Estoque> oldEstoque = estoqueRepository.findById(idEstoque);
		if (oldEstoque.isPresent()) {
			Estoque estoque = oldEstoque.get();
			estoque.setValorDeVenda(newEstoque.getValorDeVenda());
			estoqueRepository.save(estoque);
			return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
