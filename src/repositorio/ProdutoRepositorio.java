package repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import basicas.Produto;

@Stateless
public class ProdutoRepositorio {

	private List<Produto> banco = new ArrayList<Produto>();
		
	public void inserir(Produto produto) {
			this.banco.add(produto);
		}
		
	public void remover(Produto produto) {
			this.banco.remove(produto);
		}
		
	public List<Produto> listar() {
			return this.banco;
		}

	public List<Produto> getBanco() {
		return banco;
	}

	public void setBanco(List<Produto> banco) {
		this.banco = banco;
	}
	
	
	}

