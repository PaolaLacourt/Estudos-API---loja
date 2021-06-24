package com.desafio.produtos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.produtos.models.Estoque;
import com.desafio.produtos.services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;
	
	@GetMapping
	public List<Estoque> listar() {
		return estoqueService.listar();
	}
	
	@PutMapping("/{idEstoque}")
	@PreAuthorize("hasAuthority('Loja')")
	public ResponseEntity<Estoque> update(@PathVariable long idEstoque, @Valid @RequestBody Estoque newEstoque)
	{
			return estoqueService.update(idEstoque, newEstoque);
	}

}
