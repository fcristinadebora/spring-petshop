package com.debora.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.debora.petshop.domain.enums.SituacaoPagamento;

@Entity
public class PagDinheiro extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Date dataVencimento;
	private Double desconto;
	
	public PagDinheiro() {}

	public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacao, Date dataVencimento, Double desconto, Servico servico) {
		super(id, valor, situacao, servico);
		this.dataVencimento = dataVencimento;
		this.desconto = desconto;
	}

	public Date getDataPagamento() {
		return dataVencimento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataVencimento = dataPagamento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
