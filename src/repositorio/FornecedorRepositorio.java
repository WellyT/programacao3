package repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import basicas.Fornecedor;

@Stateless
public class FornecedorRepositorio {

	private List<Fornecedor> banco = new ArrayList<Fornecedor>();
	
	public void inserir(Fornecedor fornecedor) {
		this.banco.add(fornecedor);
	}
	
	public void remover(Fornecedor fornecedor) {
		this.banco.remove(fornecedor);
	}
	
	public List<Fornecedor> listar() {
		return this.banco;
	}

	public List<Fornecedor> getBanco() {
		return banco;
	}

	public void setBanco(List<Fornecedor> banco) {
		this.banco = banco;
	}
	
	
}
