package model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.entidade.Fabricante;

public class FabricanteDao {
	EntityManager em;
	
	public FabricanteDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Fabricante> listar(){
		return em.createQuery("from Fabricante", Fabricante.class).getResultList();
	}
	
	public Fabricante buscaPorId(Integer id) {
		return em.find(Fabricante.class, id);
	}
	
	public Fabricante inserir(Fabricante fabricante) {
		em.getTransaction().begin();
		em.persist(fabricante);
		em.getTransaction().commit();
		return fabricante;
	}
	
	public Fabricante excluir(Fabricante fabricante) {
		em.getTransaction().begin();
		em.remove(fabricante);
		em.getTransaction().commit();
		return fabricante;
	}
	
	public Fabricante alterar(Fabricante fabricante) {
		em.getTransaction().begin();
		em.persist(fabricante);
		em.getTransaction().commit();
		return fabricante;
	}
	
	public List<Fabricante> buscarPorNome(String str){
		TypedQuery<Fabricante> query = em.createQuery("from Fabricante WHERE fabricante_nome LIKE :n", Fabricante.class);
		query.setParameter("n", "%"+str+"%");
		return query.getResultList();
	}

}