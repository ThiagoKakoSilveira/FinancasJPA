package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Conta;
import util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager manager =  new JPAUtil().getEntityManager();
		
//		Movimentacao movimentacao = manager.find(Movimentacao.class, 3);
//		
//		System.out.println("\nTitular da conta: " + movimentacao.getConta().getTitular());
		
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
		
		@SuppressWarnings("unchecked")
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {			
			System.out.println("\nA conta com ID: "+ conta.getId() + " obtém "+conta.getMovimentacoes().size()+" movimentações!");			
		}

	}

}
