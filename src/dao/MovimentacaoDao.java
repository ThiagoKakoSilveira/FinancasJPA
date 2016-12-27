package dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import enuns.TipoMovimentacao;
import modelo.Conta;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;

	}

	public BigDecimal somaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {

		TypedQuery<BigDecimal> query = manager.createQuery(
				"select sum(m.valor) from Movimentacao m where m.conta=:pConta" + " and m.tipoMovimentacao = :pTipo",
				BigDecimal.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		BigDecimal soma = query.getSingleResult();
		
		return soma;
	}

	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {

		TypedQuery<Double> query = manager.createQuery(
				"select avg(m.valor) from Movimentacao m where m.conta=:pConta" + " and m.tipoMovimentacao = :pTipo", 
				Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		Double media = query.getSingleResult();
		
		return media;
	}

}
