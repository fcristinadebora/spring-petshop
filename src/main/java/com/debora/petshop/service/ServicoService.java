package com.debora.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.debora.petshop.domain.Servico;
import com.debora.petshop.repositories.ServicoRepository;
import com.debora.petshop.service.exceptions.DataIntegrityException;
import com.debora.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	
	public List<Servico> findAll() {
		return repo.findAll();
	}
	
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID=" + id + ", Tipo: " + Servico.class.getName() ));
	}
	
	public Servico insert(Servico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Servico update(Servico obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(int id) {
		find(id);
		
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Servico não pode ser deletada pois existem registros associados");
		}
		
	}
}
