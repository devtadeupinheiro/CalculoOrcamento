package testes;

import java.sql.Connection;

import controller.ConexaoJdbc;

public class TesteBD {
	
	private static Connection con = null;
	private static ConexaoJdbc conexao = null;

	
	public static void main (String[] args) {
		
		try {
			
			con = conectarBanco();
			System.out.println("Deu tudo certo");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public static Connection conectarBanco () {
		
		conexao = new ConexaoJdbc();
		con = conexao.getConnection();
		
		return con;
	}
	
	
}
