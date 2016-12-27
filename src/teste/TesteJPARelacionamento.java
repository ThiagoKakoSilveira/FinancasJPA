package teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import enuns.TipoMovimentacao;
import modelo.Conta;
import modelo.Movimentacao;
import util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("100");
		conta.setBanco("Banrisul");
		conta.setNumero("1025756");
		conta.setTitular("Thiago Machado Silveira");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Jogo de Playstation");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.Saida);
		movimentacao.setValor(new BigDecimal("199.00"));
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		conta = manager.find(Conta.class, 4);

		movimentacao.setConta(conta);
				
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		
		manager.close();
	}

}
