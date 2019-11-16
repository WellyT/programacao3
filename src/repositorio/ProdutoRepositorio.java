package repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import basicas.Produto;

@Stateless
public class ProdutoRepositorio {

	private List<Produto> banco = new ArrayList<Produto>();
		
	@PersistenceContext(name = "Mysql")
	private EntityManager manager;
	
	public void inserir(Produto produto) {
			this.manager.persist(produto);
		}
		
	public void remover(Produto produto) {
			this.manager.remove(produto);
		}
		
	public List<Produto> listar() {
			return this.banco;
		}

	public List<Produto> getBanco() {
		return this.banco;
	}

	public void setBanco(List<Produto> banco) {
		this.banco = banco;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	
	}

