package ctrl.negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.dao.ModeloDao;
import model.entidade.Modelo;
import ctrl.excecao.ModeloException;

public class ModeloNegocio {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_aula");
	EntityManager em = emf.createEntityManager();
	ModeloDao dao = new ModeloDao(em);
	
	public List<Modelo> listar() throws ModeloException{
		return dao.listar();
	}
	
	public Modelo buscaPorId(int id) throws ModeloException {
		return dao.buscaPorId(id);
	}
	
	public Modelo inserir(Modelo model) throws ModeloException {
		return dao.inserir(model);
	}
	
	public Modelo excluir(Modelo model) throws ModeloException {
		return dao.excluir(model);
	}

	public Modelo alterar(Modelo model) throws ModeloException {
		return dao.alterar(model);
	}
}
