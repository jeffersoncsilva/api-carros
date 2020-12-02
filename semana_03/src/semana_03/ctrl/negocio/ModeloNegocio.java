package semana_03.ctrl.negocio;

import java.util.List;

import semana_03.ctrl.excecao.DBExeption;
import semana_03.ctrl.excecao.ModeloException;
import semana_03.model.dao.DaoFactory;
import semana_03.model.dao.ModeloDao;
import semana_03.model.entidade.Modelo;

public class ModeloNegocio {
	
	private ModeloDao dao;
	
	public ModeloNegocio() {
		try {			
			dao = DaoFactory.createModeloDao();
		} catch (DBExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Modelo> listar() throws ModeloException{
		return dao.lista();
	}
	
	public Modelo buscaPorId(int id) throws ModeloException {
		return dao.procurarPorId(id);
	}
	
	public Modelo inserir(Modelo fabricante) throws ModeloException {
		return dao.inserir(fabricante);
	}
	
	public Modelo excluir(Modelo fabricante) throws ModeloException {
		return dao.excluir(fabricante);
	}

	public Modelo alterar(Modelo fabricante) throws ModeloException {
		return dao.alterar(fabricante);
	}

}
