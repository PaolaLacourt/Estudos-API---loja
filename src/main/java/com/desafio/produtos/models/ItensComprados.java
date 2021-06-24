package com.desafio.produtos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class ItensComprados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	private Produto produto;
	
	@NotNull
	@NotEmpty
	private int quantidade;
	
	@NotNull
	@NotEmpty
	private double valor;
	
	@NotNull
	@ManyToOne
	private Compra compra;

}
