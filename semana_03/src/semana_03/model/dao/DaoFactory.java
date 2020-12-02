package semana_03.model.dao;


import semana_03.ctrl.excecao.DBExeption;

public class DaoFactory {
	public static CarroDao createCarroDao() throws DBExeption {
		return new CarroDao(DB.getConnection());
	}
	
	public static FabricanteDao createFabricanteDao() throws DBExeption {
		return new FabricanteDao(DB.getConnection());
	}
	
	public static ModeloDao createModeloDao() throws DBExeption{
		return new ModeloDao(DB.getConnection());
	}
}
