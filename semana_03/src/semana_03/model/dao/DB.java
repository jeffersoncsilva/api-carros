package semana_03.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import semana_03.ctrl.excecao.DBExeption;

public class DB {
	private static Connection conn = null;
	
	public static Connection getConnection() throws DBExeption {
		if(conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				System.out.println("URL: " + url);
				conn = DriverManager.getConnection(url, props);
			}catch(SQLException e) {
				throw new DBExeption(e.getMessage());
			}
		}
		return conn;
	}
	
	private static Properties loadProperties() throws DBExeption {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch(IOException e) {
			throw new DBExeption(e.getMessage());
		}
	}
	
	public static void closeConnection() throws DBExeption {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new DBExeption(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) throws DBExeption {
		if(st != null) {
			try {
				st.close();
			}catch(SQLException e) {
				throw new DBExeption(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) throws DBExeption {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				throw new DBExeption(e.getMessage());
			}
		}
	}
	
}
