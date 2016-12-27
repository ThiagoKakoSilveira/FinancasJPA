package teste;

import javax.persistence.EntityManager;

import modelo.Conta;
import util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("557");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("50023477");
		conta.setTitular("Rickson da Silva Silveira");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(conta);
		
		manager.getTransaction().commit();
		
		manager.close();
	}

}
