package semana_03.ctrl.negocio;

import java.util.List;

import semana_03.ctrl.excecao.CarroException;
import semana_03.ctrl.excecao.DBExeption;
import semana_03.model.dao.CarroDao;
import semana_03.model.dao.DaoFactory;
import semana_03.model.entidade.Carro;

public class CarroNegocio {
	
	public CarroDao dao;
	
	public CarroNegocio() {
		try {
			dao = DaoFactory.createCarroDao();
		} catch (DBExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Carro> listar()  throws CarroException{
		return dao.lista();
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
	
	public Carro excluir(Carro c)  throws CarroException{
		return dao.excluir(c);
	}
	
}
