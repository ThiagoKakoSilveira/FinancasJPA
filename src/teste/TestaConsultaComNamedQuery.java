package teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import enuns.TipoMovimentacao;
import modelo.Conta;
import util.JPAUtil;

public class TestaConsultaComNamedQuery {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.Saida);
		
		Double media = query.getSingleResult();
		
		System.out.println(media);
	}

}
