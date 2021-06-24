package com.desafio.produtos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {


	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fornecedor");
		EntityManager eManager = factory.createEntityManager();
		eManager.getTransaction().begin();		
		eManager.close();
	}

}