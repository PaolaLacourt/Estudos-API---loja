package com.desafio.produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.produtos.models.StatusVenda;
import com.desafio.produtos.models.Venda;
import com.desafio.produtos.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public List<Venda> listar() {
		return vendaRepository.findAll();
	}
	
	public Venda adicionar(Venda venda) {
		return vendaRepository.save(venda);
	}
	
	public ResponseEntity<Venda> update(long idVenda, Venda newVenda)
	{
		java.util.Optional<Venda> oldVenda = vendaRepository.findById(idVenda);
		if (oldVenda.isPresent()) {
			Venda venda = oldVenda.get();
			venda.setStatus(newVenda.getStatus());
			venda.setStatus(StatusVenda.RECEBIDO);
			vendaRepository.save(venda);
			return new ResponseEntity<Venda>(venda, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}
