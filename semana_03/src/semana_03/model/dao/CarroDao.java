package semana_03.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semana_03.ctrl.excecao.CarroException;
import semana_03.ctrl.excecao.DBExeption;
import semana_03.model.entidade.Carro;
import semana_03.model.enumerador.TipoCarro;

public class CarroDao {
	Connection db = null;
	
	public CarroDao(Connection db ) {
		this.db = db;
	}
	
	public List<Carro> lista() throws CarroException{
		List<Carro> cars = new ArrayList<Carro>();
		try {
			String sql = "SELECT * FROM tb_carro";
			PreparedStatement ps = db.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String placa = rs.getString(2);
				int ano = rs.getInt(3);
				TipoCarro tp = TipoCarro.fomId(rs.getInt(4));
				int modeloId = rs.getInt(5);
				String cor = rs.getString(6);
				cars.add(new Carro(tp, placa, ano, cor, modeloId));
			}
		}catch (SQLException e) {
			throw new CarroException("Erro listar os carros: " +e.getMessage());
		}
		return cars;
	}
	
	public Carro procurarPorPlaca(String placa) throws CarroException {
		Carro car = null;
		try {
			String sql = "SELECT * FROM tb_carro WHERE placa = ?";
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setString(1, placa);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String pl = rs.getString(2);
				int ano = rs.getInt(3);
				TipoCarro tp = TipoCarro.fomId(rs.getInt(4));
				int modeloId = rs.getInt(5);
				String cor = rs.getString(6);
				car = new Carro(tp, pl, ano, cor, modeloId);
			}
		}catch(SQLException e ) {
			throw new CarroException("Erro ao procurar um carro pela placa. ERRO: " +e.getMessage());
		}
		
		return car;
	}
	
	public Carro inserir(Carro car) throws CarroException{
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO tb_carro (placa, ano, tipoCarro, modeloId, cor) VALUES (?, ?, ?, ?, ?);";
			ps = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, car.getPlaca());
			ps.setInt(2,  car.getAno());
			ps.setInt(3, car.getTipo().getId());
			ps.setInt(4, car.getModeloId());
			ps.setString(5, car.getCor());
			int rows = ps.executeUpdate();
			if(rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					car.setCarId(rs.getInt(1));
				}
			}else{
				throw new CarroException("Erro. Carro não foi inserido.");
			}
		}catch (SQLException e) {
			throw new CarroException("Erro ao inserir um carro no banco: "+e.getMessage());
		}finally {
			try {				
				DB.closeStatement(ps);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return car;
	}
	
	public Carro excluir(Carro c)throws CarroException {
		PreparedStatement st = null;
		try {
			st = db.prepareStatement("DELETE FROM tb_carro WHERE placa = ?");
			st.setString(1,c.getPlaca());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new CarroException("Erro excluir um carro do banco: "+e.getMessage());
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
	
	public Carro alterar(Carro c) throws CarroException{
		PreparedStatement st = null;
		try {
			st = db.prepareStatement("UPDATE tb_carro SET placa = ?, ano = ?, tipoCarro = ?, modeloId = ?, cor = ? WHERE placa = ? ");
			st.setString(1, c.getPlaca());
			st.setInt(2, c.getAno());
			st.setInt(3, c.getTipo().getId());
			st.setInt(4, c.getModeloId());
			st.setString(5, c.getCor());
			st.setString(6, c.getPlaca());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new CarroException("Erro ao atualizar carro no banco: "+e.getMessage());
		}finally {
			try {				
				DB.closeStatement(st);
			}catch (DBExeption e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return c;
	}
}