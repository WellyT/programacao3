package repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import basicas.Entrada;

@Stateless
public class EntradaRepositorio {

	@PersistenceContext(name = "Mysql")
	private EntityManager manager;
	
	public void inserir(Entrada entrada) {
		this.manager.persist(entrada);
	}
	
	public void remover(Entrada entrada) {
		this.manager.remove(entrada);
	}
}
