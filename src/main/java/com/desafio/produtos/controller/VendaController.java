package com.desafio.produtos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.produtos.models.Venda;
import com.desafio.produtos.services.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('Loja')")
	public List<Venda> listar() {
		return vendaService.listar();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Cliente')")
	@ResponseStatus(HttpStatus.CREATED)
	public Venda adicionar(@Valid @RequestBody Venda venda) {
		return vendaService.adicionar(venda);
	}
	
	@PutMapping("/{idVenda}")
	@PreAuthorize("hasAuthority('Cliente')")
	public ResponseEntity<Venda> update(@PathVariable long idVenda, @Valid @RequestBody Venda newVenda)
	{
			return vendaService.update(idVenda, newVenda);
	}
	

}
