package ctrl.servico;

import java.util.ArrayList;
import java.util.List;
import ctrl.negocio.ModeloNegocio;
import model.entidade.Modelo;
import ctrl.excecao.ModeloException;

public class ModeloServico {

	private ModeloNegocio negocio = new ModeloNegocio();
	
	public List<Modelo> listar(){
		List<Modelo> models = new ArrayList<Modelo>();
		try {
			models = negocio.listar();
		} catch (ModeloException e) {
			e.printStackTrace();
		}
		return models;
	}
	
	public Modelo procurarPorId(Integer id){
		Modelo model = null;
		
		try {
			model = negocio.buscaPorId(id);
		} catch (ModeloException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public Modelo inserir(Modelo m) {
		try {
			m = negocio.inserir(m);
		} catch (ModeloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	public Modelo excluir(Modelo model) {
		try {
			model = negocio.excluir(model);
		} catch (ModeloException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public Modelo alterar(Modelo model) {
		try {
			model = negocio.alterar(model);
		} catch (ModeloException e) {
			e.printStackTrace();
		}
		return model;
	}
}
