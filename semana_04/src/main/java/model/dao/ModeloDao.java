package model.dao;

import java.util.List;
import model.entidade.Modelo;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class ModeloDao {
	EntityManager em;
	
	public ModeloDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Modelo> listar(){
		return em.createQuery("from Modelo", Modelo.class).getResultList();
	}
	
	public Modelo buscaPorId(Integer id) {
		return em.find(Modelo.class, id);
	}
	
	public Modelo inserir(Modelo model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
		return model;
	}
	
	public Modelo excluir(Modelo model) {
		em.getTransaction().begin();
		em.remove(model);
		em.getTransaction().commit();
		return model;
	}
	
	public Modelo alterar(Modelo model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
		return model;
	}
	
	public List<Modelo> buscarPorNome(String str){
		TypedQuery<Modelo> query = em.createQuery("from Model WHERE nome LIKE :n", Modelo.class);
		query.setParameter("n", "%"+str+"%");
		return query.getResultList();
	}

}
