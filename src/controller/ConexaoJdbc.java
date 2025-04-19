package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJdbc {
	
	private Connection con = null;
	
	private String nomeHost = null;
	private String usuario = null;
	private String senha = null;
	private String url = null;
	private String jdbcDriver = null;
	private String nomeBanco = null;
	private String prefixBanco = null;
	private String portaBanco = null;
	private String outrasConfiguracoes = null;
	
	public ConexaoJdbc () {
		
		nomeHost = "localhost";
		usuario = "postgres";
		senha = "Eusei2202@";
		jdbcDriver = "org.postgresql.Driver";
		nomeBanco = "app-orcamento";
		prefixBanco = "jdbc:postgresql://";
		portaBanco = "5432/";
		
		url = prefixBanco + nomeHost + ":" + portaBanco + nomeBanco;
		
	}

	
	/*
	 * Verifica se a conexão é nula, se não for, ele torna ela nula e chama novamente a si próprio (método recursivo).
	 */
	
	public Connection getConnection() {
		
		try {
			
			if (con == null) {
				
				Class.forName(jdbcDriver);
				con = DriverManager.getConnection(url, usuario, senha);
				
			} else if (con.isClosed()){
				
				con = null;
				return getConnection();
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			//Colocar sistema de log
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao conectar com o banco de dados" + e.getMessage());
			
			//colocar sistema de log
			
		}
		
		return con;
	}
	
	public void closeConnection () {
		
		if (con != null)  {
			
			try {
				
				con.close();
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao fechar a conexão" + e.getMessage());
				//Colocar sistema de log
			}
			
		}
		
	}
}
