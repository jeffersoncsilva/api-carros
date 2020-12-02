package semana_03.ctrl.servico;

import java.util.ArrayList;
import java.util.List;

import semana_03.ctrl.excecao.CarroException;
import semana_03.ctrl.negocio.CarroNegocio;
import semana_03.model.entidade.Carro;

public class CarroServico {
	
	private CarroNegocio negocio = new CarroNegocio();
	
	public List<Carro> listar(){
		List<Carro> r = new ArrayList<Carro>();		
		try {
			r = negocio.listar();
		}catch (CarroException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Carro procurarPorPlaca(String placa) {
		Carro c = null;
		try {
			c = negocio.procurarPorPlaca(placa);
		}catch (CarroException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public Carro inserir(Carro c) {
		try {
			c = negocio.inserir(c);
		}catch(CarroException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public Carro alterar(Carro c) {
		try {
			c = negocio.alterar(c);
		}catch(CarroException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public Carro excluir(Carro c) {
		try {
			c = negocio.excluir(c);
		}catch (CarroException e) {
			e.printStackTrace();
		}
		return c;
	}
}
