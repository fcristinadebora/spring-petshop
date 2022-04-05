package com.debora.petshop.domain;

import javax.persistence.Entity;

import com.debora.petshop.domain.enums.SituacaoPagamento;

@Entity
public class PagCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer parcelas;
	
	public PagCartao() {}

	public PagCartao(Integer id, Double valor, SituacaoPagamento situacao, Integer parcelas, Servico servico) {
		super(id, valor, situacao, servico);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
