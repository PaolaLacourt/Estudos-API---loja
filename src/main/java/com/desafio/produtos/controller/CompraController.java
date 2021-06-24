package com.desafio.produtos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.produtos.models.Compra;
import com.desafio.produtos.services.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('Loja')")
	public List<Compra> listar() {
		return compraService.listar();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Loja')")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra adicionar(@Valid @RequestBody Compra compra) {
		return compraService.adicionar(compra);
	}
	

}
