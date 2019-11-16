package controlador;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import basicas.Fornecedor;
import repositorio.FornecedorRepositorio;

@SuppressWarnings("serial")
@ManagedBean(name = "FornecedorBean")
@SessionScoped
public class FornecedorBean implements Serializable{
	
	@Inject
	private FornecedorRepositorio repositorio;
	
	private String nome;
	private String cnpj;
	private String endereco;
	
	public List<Fornecedor> listar(){
		return this.repositorio.listar();
	}
	
	public List<Fornecedor> cadastrar(Fornecedor fornecedor) {
		Fornecedor f = new Fornecedor();
		f.setNome(this.nome);
		f.setCnpj(this.cnpj);
		f.setEndereco(this.endereco);
		
		this.repositorio.inserir(f);
		this.nome=null;
		this.cnpj=null;
		this.endereco=null;
		
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto inserido com sucesso",null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		
		
		return null;
	}
	
	public String load(Fornecedor fornecedor) {
		this.nome = fornecedor.getNome();
		this.cnpj = fornecedor.getCnpj();
		this.endereco =fornecedor.getEndereco();
		return null;
	}
	
	public String remover(Fornecedor fornecedor) {
		this.repositorio.remover(fornecedor);
		
		return null;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public FornecedorRepositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(FornecedorRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	

}
