package ctrl.negocio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ctrl.excecao.FabricanteException;
import model.dao.FabricanteDao;
import model.entidade.Fabricante;

public class FabricanteNegocio {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_aula");
	EntityManager em = emf.createEntityManager();
	FabricanteDao dao = new FabricanteDao(em);
	
	public List<Fabricante> listar() throws FabricanteException{
		return dao.listar();
	}
	
	public Fabricante buscaPorId(Integer id) throws FabricanteException{
		return dao.buscaPorId(id);
	}
	
	public Fabricante inserir(Fabricante fabricante) throws FabricanteException{
		return dao.inserir(fabricante);
	}
	
	public Fabricante excluir(Fabricante fab) throws FabricanteException{	
		fab = dao.buscaPorId(fab.getFabId());
		return dao.excluir(fab);
	}
	
	public Fabricante alterar(Fabricante fabricante) throws FabricanteException{
		return dao.alterar(fabricante);
	}
	
	public List<Fabricante> buscarPorNome(String str) throws FabricanteException{
		return dao.buscarPorNome(str);
	}
	
	
}
