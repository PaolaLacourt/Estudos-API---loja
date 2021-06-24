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

import com.desafio.produtos.models.Cliente;
import com.desafio.produtos.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('Loja')")
	public List<Cliente> lister() {
		return clienteService.lister();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteService.adicionar(cliente);
	}
	
	@PutMapping("/{idCliente}")
	@PreAuthorize("hasAuthority('Loja')")
	public ResponseEntity<Cliente> update(@PathVariable long idCliente, @Valid @RequestBody Cliente newCliente)
	{
		return clienteService.update(idCliente, newCliente);
	}
	
	@DeleteMapping("/{idCliente}")
	@PreAuthorize("hasAuthority('Loja')")
	public void deleteCliente(@PathVariable long idCliente) {
		clienteService.deleteCliente(idCliente);
	}


}
