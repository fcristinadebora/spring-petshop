package com.debora.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.debora.petshop.domain.Categoria;
import com.debora.petshop.domain.Especie;
import com.debora.petshop.domain.Pet;
import com.debora.petshop.domain.Produto;
import com.debora.petshop.domain.Raca;
import com.debora.petshop.repositories.CategoriaRepository;
import com.debora.petshop.repositories.EspecieRepository;
import com.debora.petshop.repositories.PetRepository;
import com.debora.petshop.repositories.ProdutoRepository;
import com.debora.petshop.repositories.RacaRepository;

@Component
public class PopulaDados {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	RacaRepository racaRepository;
	
	@PostConstruct
	public void cadastrar() {
		Categoria cat1 = new Categoria(null, "Alimento");
		Categoria cat2 = new Categoria(null, "Remédio");
		Categoria cat3 = new Categoria(null, "Cosmético");
		
		Produto prod1 = new Produto(null, "Ração", 100.0);
		Produto prod2 = new Produto(null, "Sachê", 80.0);
		Produto prod3 = new Produto(null, "Shampoo", 50.0);
		Produto prod4 = new Produto(null, "Vermífugo", 20.0);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2));
		cat2.getProdutos().addAll(Arrays.asList(prod3, prod4));
		cat3.getProdutos().addAll(Arrays.asList(prod3));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat3));
		prod4.getCategorias().addAll(Arrays.asList(cat2,cat3));
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
		
		Especie es1 = new Especie(null, "Cachorro");
		Especie es2 = new Especie(null, "Gato");
		
		Raca ra1 = new Raca(null, "Akita");
		Raca ra2 = new Raca(null, "Shitsu");
		Raca ra3 = new Raca(null, "Persa");
		
		Pet pet1 = new Pet(null, "Jonh", 6, es1, ra2);
		Pet pet2 = new Pet(null, "Hanna", 5, es1, ra1);
		Pet pet3 = new Pet(null, "Mewth", 8, es2, ra3);
		
		especieRepository.saveAll(Arrays.asList(es1, es2));
		racaRepository.saveAll(Arrays.asList(ra1, ra2, ra3));
		petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));
	}
	
}
