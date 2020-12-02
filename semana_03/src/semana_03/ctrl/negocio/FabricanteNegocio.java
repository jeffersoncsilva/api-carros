package semana_03.ctrl.negocio;

import java.util.List;

import semana_03.ctrl.excecao.DBExeption;
import semana_03.ctrl.excecao.FabricanteException;
import semana_03.model.dao.DaoFactory;
import semana_03.model.dao.FabricanteDao;
import semana_03.model.entidade.Fabricante;

public class FabricanteNegocio {
	
	private FabricanteDao dao;
	
	public FabricanteNegocio() {
		 try {
			dao = DaoFactory.createFabricanteDao();
		} catch (DBExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Fabricante> listar() throws FabricanteException{
		return dao.lista();
	}
	
	public Fabricante buscaPorId(int id) throws FabricanteException {
		return dao.procurarPorId(id);
	}
	
	public Fabricante inserir(Fabricante fabricante) throws FabricanteException {
		return dao.inserir(fabricante);
	}
	
	public Fabricante excluir(Fabricante fabricante) throws FabricanteException {
		return dao.excluir(fabricante);
	}

	public Fabricante alterar(Fabricante fabricante) throws FabricanteException {
		return dao.alterar(fabricante);
	}

}
