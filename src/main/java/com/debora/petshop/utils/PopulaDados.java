package com.debora.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.debora.petshop.domain.Categoria;
import com.debora.petshop.domain.Cidade;
import com.debora.petshop.domain.Cliente;
import com.debora.petshop.domain.Endereco;
import com.debora.petshop.domain.Especie;
import com.debora.petshop.domain.Estado;
import com.debora.petshop.domain.Funcionario;
import com.debora.petshop.domain.PagCartao;
import com.debora.petshop.domain.PagDinheiro;
import com.debora.petshop.domain.Pagamento;
import com.debora.petshop.domain.Pet;
import com.debora.petshop.domain.Produto;
import com.debora.petshop.domain.Raca;
import com.debora.petshop.domain.Servico;
import com.debora.petshop.domain.enums.SituacaoPagamento;
import com.debora.petshop.repositories.CategoriaRepository;
import com.debora.petshop.repositories.CidadeRepository;
import com.debora.petshop.repositories.EnderecoRepository;
import com.debora.petshop.repositories.EspecieRepository;
import com.debora.petshop.repositories.EstadoRepository;
import com.debora.petshop.repositories.PagamentoRepository;
import com.debora.petshop.repositories.PessoaRepository;
import com.debora.petshop.repositories.PetRepository;
import com.debora.petshop.repositories.ProdutoRepository;
import com.debora.petshop.repositories.RacaRepository;
import com.debora.petshop.repositories.ServicoRepository;

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
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	//	@PostConstruct
	public void cadastrar() throws ParseException {
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
		
		Estado est1 = new Estado(null, "MG");
		Estado est2 = new Estado(null, "SP");
		
		Cidade cid1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade cid2 = new Cidade(null, "Capelinha", est1);
		Cidade cid3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente clt1 = new Cliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");
		clt1.getTelefones().addAll(Arrays.asList("3516-2000","9191-0000"));
		
		Funcionario fnc1 = new Funcionario(null, "Maria Jose", "maria@mail.com", "551.872.200.12", "FISICA");
		fnc1.getTelefones().addAll(Arrays.asList("3279-0001","9090-0002"));
		
		Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", cid1, clt1);
		Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", cid2, fnc1);
		Endereco end3 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", cid3, fnc1);
		
		pessoaRepository.saveAll(Arrays.asList(clt1, fnc1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date data1 = sdf.parse("03/09/2021 12:00");
		Date data2 = sdf.parse("04/09/2021 12:00");	
		

		Servico srv1 = new Servico(null, data1, data2, "Tosa", clt1, fnc1, pet1);
		Servico srv2 = new Servico(null, data1, data2, "Hotel", clt1, fnc1, pet2);
		Servico srv3 = new Servico(null, data1, data2, "Vermifugação", clt1, fnc1, pet3);
		
		Pagamento pgt1 = new PagCartao(null, 60.00, SituacaoPagamento.QUITADO, 6, srv2);
		srv2.setPagamento(pgt1);
		
		Pagamento pgt2 = new PagDinheiro(null, 100.00, SituacaoPagamento.PENDENTE, data2, 0.0, srv1);
		srv1.setPagamento(pgt2);
		
		Pagamento pgt3 = new PagDinheiro(null, 75.00, SituacaoPagamento.QUITADO, data2, 0.0, srv3);
		srv3.setPagamento(pgt3);
		
		clt1.getServicos().addAll(Arrays.asList(srv1, srv2));
		fnc1.getServicos().addAll(Arrays.asList(srv1, srv2));
		
		srv2.getProdutos().addAll(Arrays.asList(prod1, prod2, prod4));
		srv3.getProdutos().addAll(Arrays.asList(prod3));
		
		servicoRepository.saveAll(Arrays.asList(srv1, srv2));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2));
		
	}
	
}
