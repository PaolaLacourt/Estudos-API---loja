package com.desafio.produtos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

import com.desafio.produtos.controller.form.BuscaProdutoForm;
import com.desafio.produtos.models.Produto;
import com.desafio.produtos.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public String buscaComPaginacaoParametrosEOrdenacao(BuscaProdutoForm buscaProdutoForm, Pageable pageable) {
		return produtoService.buscaComPaginacaoParametrosEOrdenacao(buscaProdutoForm, pageable);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('Loja')")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@Valid @RequestBody Produto produto) {
		return produtoService.adicionar(produto);
	}
	
	@PutMapping("/{idProduto}")
	@PreAuthorize("hasAuthority('Loja')")
	public ResponseEntity<Produto> update(@PathVariable long idProduto, @Valid @RequestBody Produto newProduto)
	{
			return produtoService.update(idProduto, newProduto);
	}
	
	@DeleteMapping("/{idProduto}")
	@PreAuthorize("hasAuthority('Loja')")
	public void deleteProduto(@PathVariable long idProduto) {
		produtoService.deleteProduto(idProduto);
	}

}
