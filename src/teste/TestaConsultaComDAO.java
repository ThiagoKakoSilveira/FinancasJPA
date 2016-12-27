package teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import dao.MovimentacaoDao;
import enuns.TipoMovimentacao;
import modelo.Conta;
import util.JPAUtil;

public class TestaConsultaComDAO {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1);
		
//		Query query = manager.createQuery("select sum(m.valor) from Movimentacao m where m.conta=:pConta"
//				+ " and m.tipoMovimentacao = :pTipo"); aqui sem TypedQuery
		
//		BigDecimal soma = (BigDecimal) query.getSingleResult(); sem TypedQuery precisa de Cast
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		BigDecimal soma = dao.somaDaContaPeloTipo(conta, TipoMovimentacao.Saida);
		Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.Saida);
		
		System.out.println("\n"+soma);
		System.out.println("\n"+media);

	}

}
