package semana_03.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semana_03.ctrl.excecao.DBExeption;
import semana_03.ctrl.excecao.ModeloException;
import semana_03.model.entidade.Modelo;


public class ModeloDao {
	
	Connection conn;
	
	public ModeloDao(Connection con) {
		this.conn = con;
	}
	
	public List<Modelo> lista() throws ModeloException{
		List<Modelo> models = new ArrayList<Modelo>();
		try {
			String sql = "SELECT * FROM tb_modelo";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nomeModelo = rs.getString(2);
				int fabId = rs.getInt(3);
				models.add(new Modelo(nomeModelo, id, fabId));
			}
		}catch(SQLException e) {
			throw new ModeloException("Erro ao listar os modelos. " + e.getMessage());
		}
		return models;
	}
	
	public Modelo procurarPorId(int id) throws ModeloException{
		Modelo model = null;
		try {
			String sql = "SELECT * FROM tb_modelo WHERE modeloId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id1 = rs.getInt(1);
				String nomeModelo = rs.getString(2);
				int fabId = rs.getInt(3);
				model = new Modelo(nomeModelo, id1, fabId);
			}
		}catch(SQLException e ) {
			throw new ModeloException("Erro ao procurar um carro pela placa. ERRO: " +e.getMessage());
		}
		
		return model;
	}
	
	public Modelo inserir(Modelo f) throws ModeloException {
		PreparedStatement ps = null;
		try {
			//insert into tb_modelo (modeloNome, fabricanteId) values ("Ford", 2);
			String sql = "INSERT INTO tb_modelo (modeloNome, fabricanteId) VALUES (?, ?);";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, f.getNomeModelo());
			ps.setInt(2, f.getModeloId());
			int rows = ps.executeUpdate();
			if(rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					f.setModeloId(rs.getInt(1));
				}
			}else{
				throw new ModeloException("Erro. Carro não foi inserido.");
			}
		}catch (SQLException e) {
			throw new ModeloException("Erro ao inserir um carro no banco: "+e.getMessage());
		}finally {
			try {				
				DB.closeStatement(ps);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return f;
	}
	
	public Modelo excluir(Modelo c) throws ModeloException{
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tb_modelo WHERE modeloId = ?");
			st.setInt(1,c.getModeloId());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new ModeloException("Erro excluir um modelo do banco: "+e.getMessage());
		} 
		finally {
			try {				
				DB.closeStatement(st);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return c;
	}
	
	public Modelo alterar(Modelo m) throws ModeloException{
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE tb_modelo SET modeloNome = ?, fabricanteId = ? WHERE modeloId = ? ");
			st.setString(1, m.getNomeModelo());
			st.setInt(2, m.getFabricanteId());
			st.setInt(3, m.getModeloId());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new ModeloException("Erro ao atualizar carro no banco: "+e.getMessage());
		}finally {
			try {				
				DB.closeStatement(st);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return m;
	}

}
