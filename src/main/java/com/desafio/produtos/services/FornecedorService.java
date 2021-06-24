package com.desafio.produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.produtos.models.Fornecedor;
import com.desafio.produtos.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;   
	
	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}
	
	public Fornecedor adicionar( Fornecedor fornecedor)  {
		return fornecedorRepository.save(fornecedor);
	}
	
	public ResponseEntity<Fornecedor> update(long idFornecedor, Fornecedor newFornecedor)
	{
		java.util.Optional<Fornecedor> oldFornecedor = fornecedorRepository.findById(idFornecedor);
		if (oldFornecedor.isPresent()) {
			Fornecedor fornecedor = oldFornecedor.get();
			fornecedor.setCnpj(newFornecedor.getCnpj());
			fornecedor.setNome(newFornecedor.getNome());
			fornecedor.setTelefone(newFornecedor.getTelefone());
			fornecedor.setEmail(newFornecedor.getEmail());
			fornecedor.getEndereco().setLogradouro(newFornecedor.getEndereco().getLogradouro());
			fornecedor.getEndereco().setNumero(newFornecedor.getEndereco().getNumero());
			fornecedor.getEndereco().setComplemento(newFornecedor.getEndereco().getComplemento());
			fornecedor.getEndereco().setCep(newFornecedor.getEndereco().getCep());
			fornecedor.getEndereco().setBairro(newFornecedor.getEndereco().getBairro());
			fornecedor.getEndereco().setMunicipio(newFornecedor.getEndereco().getMunicipio());
			fornecedor.getEndereco().setEstado(newFornecedor.getEndereco().getEstado());			
			fornecedorRepository.save(fornecedor);
			return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	public void deleteFornecedor(long idFornecedor) {
		fornecedorRepository.deleteById(idFornecedor);
	}

}
