package controlador;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import repositorio.ProdutoRepositorio;
import basicas.Produto;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean(name = "ProdutoBean")
public class ProdutoBean  implements Serializable {
	
	@Inject
	private ProdutoRepositorio repositorio;
	
	private String nome;
	private int quantidade;


	public void reset(){
		this.nome=null;
		this.quantidade=0;
	}
	
	public List<Produto> listar(){
		return this.repositorio.listar();
	}
	
	public String cadastrar(Produto produto){
		Produto p = new Produto();
		p.setNome(this.nome);
		p.setQuantidade(this.quantidade);
		
		this.repositorio.inserir(p);
		this.nome = null;
		this.quantidade = 0;
		
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto inserido com sucesso",null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		
		return null;
	}
	
	public String load(Produto produto){
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();
		return null;
	}

	public String remover(Produto produto){
		this.repositorio.remover(produto);
		
		return null;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	
	
	
}
