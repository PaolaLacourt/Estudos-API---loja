package com.desafio.produtos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.produtos.models.Fornecedor;
import com.desafio.produtos.services.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;   
	
	@GetMapping
	@PreAuthorize("hasAuthority('Loja')")
	public List<Fornecedor> listar() {
		return fornecedorService.listar();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Loja')")
	@ResponseStatus(HttpStatus.CREATED)
	public Fornecedor adicionar(@Valid @RequestBody Fornecedor fornecedor) {
		return fornecedorService.adicionar(fornecedor);
	}
	
	@PutMapping("/{idFornecedor}")
	@PreAuthorize("hasAuthority('Loja')")
	public ResponseEntity<Fornecedor> update(@PathVariable long idFornecedor, @Valid @RequestBody Fornecedor newFornecedor)
	{
			return fornecedorService.update(idFornecedor, newFornecedor);
	}
	
	
	@DeleteMapping("/{idFornecedor}")
	@PreAuthorize("hasAuthority('Loja')")
	public void deleteFornecedor(@PathVariable long idFornecedor) {
		fornecedorService.deleteFornecedor(idFornecedor);
	}

}
