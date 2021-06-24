package com.desafio.produtos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Produto idProduto;
	
	@NotNull
	@NotEmpty
	private int quantidade;
	
	@NotNull
	@NotEmpty
	@DecimalMin(value="0.00")
	@Digits(integer = 6, fraction = 2)
	private double valorDeVenda;


	public void somaEstoque(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void diminuiEstoque(int quantidade) {
		this.quantidade -= quantidade;
	}

	

}
