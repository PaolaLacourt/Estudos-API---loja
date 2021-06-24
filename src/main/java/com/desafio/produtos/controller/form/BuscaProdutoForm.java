package com.desafio.produtos.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.desafio.produtos.models.Produto;


public class BuscaProdutoForm {

	private String nome;
	private String descricao;
	
	public BuscaProdutoForm(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Specification<Produto> toSpec() {
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(org.springframework.util.StringUtils.hasText(nome)) {
				Path<String> campoNome = root.<String>get("nome");
				Predicate predicadoNome = builder.like(campoNome, "%"+nome+"%");		
				predicados.add(predicadoNome);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	
}
