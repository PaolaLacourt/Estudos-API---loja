package com.desafio.produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.produtos.models.Cliente;
import com.desafio.produtos.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> lister() {
		return clienteRepository.findAll();
	}

	public Cliente adicionar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public ResponseEntity<Cliente> update(long idCliente, Cliente newCliente) {
		java.util.Optional<Cliente> oldCliente = clienteRepository.findById(idCliente);
		if (oldCliente.isPresent()) {
			Cliente cliente = oldCliente.get();
			cliente.setCpf(newCliente.getCpf());
			cliente.setNome(newCliente.getNome());
			cliente.setTelefone(newCliente.getTelefone());
			cliente.setEmail(newCliente.getEmail());
			cliente.getEndereco().setLogradouro(newCliente.getEndereco().getLogradouro());
			cliente.getEndereco().setNumero(newCliente.getEndereco().getNumero());
			cliente.getEndereco().setComplemento(newCliente.getEndereco().getComplemento());
			cliente.getEndereco().setCep(newCliente.getEndereco().getCep());
			cliente.getEndereco().setBairro(newCliente.getEndereco().getBairro());
			cliente.getEndereco().setMunicipio(newCliente.getEndereco().getMunicipio());
			cliente.getEndereco().setEstado(newCliente.getEndereco().getEstado());
			clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public void deleteCliente(long idCliente) {
		clienteRepository.deleteById(idCliente);
}
}
