package semana_03.ctrl.servico;

import java.util.ArrayList;
import java.util.List;

import semana_03.ctrl.excecao.FabricanteException;
import semana_03.ctrl.negocio.FabricanteNegocio;
import semana_03.model.entidade.Fabricante;

public class FabricanteServico {
	
	private FabricanteNegocio negocio = new FabricanteNegocio();
	
	public List<Fabricante> listar(){
		List<Fabricante> retorno = new ArrayList<Fabricante>();
		try {
			retorno = negocio.listar();
		} catch (FabricanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	public Fabricante procurarPorId(Integer id) {
		Fabricante fabricante = null;
		
		try {
			fabricante = negocio.buscaPorId(id);
		} catch (FabricanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fabricante;
	}
	
	public Fabricante inserir(Fabricante fabricante) {
		
		try {
			fabricante = negocio.inserir(fabricante);
		} catch (FabricanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}

	public Fabricante excluir(Fabricante fabricante) {
		try {
			fabricante = negocio.excluir(fabricante);
		} catch (FabricanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fabricante;
	}
	
	public Fabricante alterar(Fabricante fabricante) {
		
		try {
			fabricante = negocio.alterar(fabricante);
		} catch (FabricanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}
}
