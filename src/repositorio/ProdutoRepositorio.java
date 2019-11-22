package repositorio;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.jboss.resteasy.core.NoMessageBodyWriterFoundFailure;

import basicas.Produto;

@Stateless
public class ProdutoRepositorio {
	
		
	@PersistenceContext(name = "Mysql")
	private EntityManager manager;
	
	public void inserir(Produto produto) {
		
			this.manager.persist(produto);
		}
		
	public void remover(Produto produto) {
			this.manager.remove(produto);
		}
		
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		Query query = this.manager.createQuery("From Produto");
		List<Produto> result = query.getResultList();
			return result;
		}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
/*	public boolean isEstoque() throws Exception{
		boolean result = false;
		
		Class.forName("org.hibernate.jpa.HibernatePersistenceProvider").newInstance();
		Connection conexao = DriverManager.getConnection("java:jboss/datasources/Mysql-DS;user=root;password=root");
		PreparedStatement consulta = conexao.prepareStatement("SELECT nome FROM Produto WHERE nome=?");
		consulta.setString(1,nome.getNome());
		ResultSet resultadoConsulta= consulta.executeQuery();
		
		if (resultadoConsulta != null) {
			while (resultadoConsulta.next()) {
				String nomeBanco = resultadoConsulta.getString("nome");
				
				if (nomeBanco != null) {
					result=true;
				}
				
			}
			
		}
		conexao.commit();
		conexao.close();
		return result;
	}*/
	
	}

