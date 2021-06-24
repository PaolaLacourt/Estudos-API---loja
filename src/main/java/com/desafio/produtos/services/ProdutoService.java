package com.desafio.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.produtos.controller.form.BuscaProdutoForm;
import com.desafio.produtos.models.Produto;
import com.desafio.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public String buscaComPaginacaoParametrosEOrdenacao(BuscaProdutoForm buscaProdutoForm, Pageable pageable) {
		return produtoRepository.findAll(buscaProdutoForm.toSpec(),pageable).getContent().toString();
	}

	public Produto adicionar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public ResponseEntity<Produto> update(long idProduto, Produto newProduto)
	{
		java.util.Optional<Produto> oldProduto = produtoRepository.findById(idProduto);
		if (oldProduto.isPresent()) {
			Produto produto = oldProduto.get();
			produto.setNome(newProduto.getNome());
			produto.setDescricao(newProduto.getDescricao());
			produtoRepository.save(produto);
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public void deleteProduto(long idProduto) {
		produtoRepository.deleteById(idProduto);
	}
}
