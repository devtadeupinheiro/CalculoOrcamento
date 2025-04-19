package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioDAO {

	private ConexaoJdbc conexao;
	private Connection con;
	private static PreparedStatement stmt; //Criei fora dos m�todos para reaproveitar o m�todo de fechamento da conex�o.
	private static ResultSet resultSet;
	
	public UsuarioDAO () {}
	
	public Connection conectarBanco () {
			
		this.conexao = new ConexaoJdbc();
		this.con = conexao.getConnection();
		
		return con;
	}
	
	public Usuario consultarUsuario (String nomeUsuario, String senhaCriptografada) throws Exception {
		
		this.con = conectarBanco();
		Usuario usuario = null;
		String url = "SELECT * FROM usuario WHERE usuario = ?, senha = ?";
		int i = 0;
		
		try {
			
			stmt = this.con.prepareStatement(url);
			stmt.setString(i++, nomeUsuario);
			stmt.setString(i++, senhaCriptografada);
			
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				
				usuario = new Usuario (resultSet.getInt("id"),
										resultSet.getString("usuario"),
										resultSet.getString("senha"));
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			fecharConexao();
			
		}
		
		if (usuario == null) {
			
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel localizar o usu�rio selecionado", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("N�o foi poss�vel localizar o usu�rio selecionado");
			
		}
		
		return usuario;
		
	}
	
 	private void fecharConexao() {
		
		try {
			
			if (resultSet != null) {
				
				resultSet.close();
				
			}
			
			if (stmt != null) {
				
				stmt.close();
				
			}
			
			con.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
