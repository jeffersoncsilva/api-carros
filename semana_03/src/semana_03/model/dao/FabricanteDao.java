package semana_03.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import semana_03.ctrl.excecao.DBExeption;
import semana_03.ctrl.excecao.FabricanteException;
import semana_03.model.entidade.Fabricante;

public class FabricanteDao {
	Connection db = null;
	
	public FabricanteDao(Connection db) {
		this.db = db;
	}
	
	public List<Fabricante> lista(){
		List<Fabricante> fabs = new ArrayList<Fabricante>();
		try {
			String sql = "SELECT * FROM tb_fabricante";
			PreparedStatement ps = db.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("fabricanteId");
				String nome = rs.getString(2);
				Fabricante fab = new Fabricante(nome, id);
				fabs.add(fab);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return fabs;
	}
	
	public Fabricante procurarPorId(int id) {
		Fabricante fab = null;
		try {
			String sql = "SELECT * FROM tb_fabricante WHERE fabricanteId = ?;";
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id1 = rs.getInt("fabricanteId");
				String nome = rs.getString(2);
				fab = new Fabricante(nome, id1);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return fab;
	}
	
	public Fabricante inserir(Fabricante f) throws FabricanteException {
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO tb_fabricante (fabricanteNome) VALUES (?);";
			ps = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, f.getFabriNome());
			int rows = ps.executeUpdate();
			if(rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					f.setFabId(rs.getInt(1));
				}
			}else{
				throw new FabricanteException("Ação inesperada! Nenhuma linha foi inserida.");
			}
		}catch (SQLException e) {
			throw new FabricanteException("Erro no banco de dados: "+e.getMessage());
		}finally {
			try {				
				DB.closeStatement(ps);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return f;
	}
	
	public Fabricante excluir(Fabricante fab) throws FabricanteException  {
		PreparedStatement st = null;
		try {
			st = db.prepareStatement(
				"DELETE FROM tb_fabricante WHERE fabricanteId = ?");
			st.setInt(1,fab.getFabId());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new FabricanteException("Erro ao apagar fabricante: "+e.getMessage());
		} 
		finally {
			try {				
				DB.closeStatement(st);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return fab;
	}
	
	public Fabricante alterar(Fabricante fab) throws FabricanteException {
		PreparedStatement st = null;
		try {
			st = db.prepareStatement("UPDATE tb_fabricante SET fabricanteNome = ? WHERE fabricanteId = ? ");
			st.setString(1, fab.getFabriNome());
			st.setInt(2, fab.getFabId());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new FabricanteException("Erro no banco de dados: "+e.getMessage());
		}finally {
			try {				
				DB.closeStatement(st);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return fab;
	}

}
