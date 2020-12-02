package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.entidade.Carro;


public class CarroDao {
	EntityManager em;
	
	public CarroDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Carro> listar(){
		return em.createQuery("from Carro", Carro.class).getResultList();
	}
	
	public Carro procurarPorPlaca(String placa) {
		TypedQuery<Carro> query = em.createQuery("from Carro WHERE placa LIKE :n", Carro.class);
		query.setParameter("n", placa);
		return query.getResultList().get(0);
	}
	
	public Carro inserir(Carro car) {
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		return car;
	}
	
	public Carro excluir(Carro car) {
		em.getTransaction().begin();
		em.remove(car);
		em.getTransaction().commit();
		return car;
	}
	
	public Carro alterar(Carro car) {
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		return car;
	}
}
