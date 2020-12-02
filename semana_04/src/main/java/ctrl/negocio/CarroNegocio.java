package ctrl.negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.dao.CarroDao;
import model.entidade.Carro;
import ctrl.excecao.CarroException;

public class CarroNegocio {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_aula");
	EntityManager em = emf.createEntityManager();
	CarroDao dao = new CarroDao(em);
	
	public List<Carro> listar()  throws CarroException{
		return dao.listar();
	}
	
	public Carro procurarPorPlaca(String placa) throws CarroException{
		if(placa.length() != 8) {
			throw new CarroException("Placa deve ter 8 caracteres.");
		}	
		return dao.procurarPorPlaca(placa);
	}
	
	public Carro inserir(Carro car) throws CarroException{
		if(car.getPlaca().length() != 8) {
			throw new CarroException("Placa deve ter 8 caracteres.");
		}
		return dao.inserir(car);
	}
	
	public Carro alterar(Carro car) throws CarroException{
		if(car.getPlaca().length() != 8) {
			throw new CarroException("Placa deve ter 8 caracteres.");
		}
		return dao.alterar(car);
	}
	
	public Carro excluir(Carro car)  throws CarroException{
		return dao.excluir(car);
	}
	
}
