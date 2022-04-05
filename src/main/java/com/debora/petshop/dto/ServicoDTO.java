package com.debora.petshop.dto;

import java.io.Serializable;
import java.util.Date;

import com.debora.petshop.domain.Servico;

public class ServicoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private Date dataEntrada; 
	private Date dataSaida; 
	
	public ServicoDTO () {}

	public ServicoDTO(Servico obj) {
		super();
		this.descricao = obj.getDescricao();
		this.dataEntrada = obj.getDataEntrada();
		this.dataSaida = obj.getDataSaida();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
}
