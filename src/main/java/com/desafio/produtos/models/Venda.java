package com.desafio.produtos.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente nome;
	
	@OneToMany
	private List<Produto> itensDaVenda;	
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<ItensVendidos> itensVendidos = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private StatusVenda status = StatusVenda.PENDENTE;

	public Object get() {
		return null;
	}

}
