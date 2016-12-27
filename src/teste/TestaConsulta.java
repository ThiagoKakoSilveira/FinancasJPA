package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import enuns.TipoMovimentacao;
import modelo.Conta;
import modelo.Movimentacao;
import util.JPAUtil;

public class TestaConsulta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta"
				+ " and m.tipoMovimentacao = :pTipo"
				+ " order by m.valor desc");
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.Saida);
		
		@SuppressWarnings("unchecked")
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println("Descrição ..: " + m.getDescricao());
			System.out.println("Valor ......: " + m.getValor());
		}
	}

}
