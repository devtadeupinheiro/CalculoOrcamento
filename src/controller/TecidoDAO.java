package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Produto;
import model.Tecido;

public class TecidoDAO {
	
	
	private ConexaoJdbc conexao;
	private Connection con;
	private static PreparedStatement stmt; //Criei fora dos m�todos para reaproveitar o m�todo de fechamento da conex�o.
	private static ResultSet resultSet;
	
	/*public ProdutoDAO () {
		
		this.conexao = new ConexaoJdbc();
		this.con = conexao.getConnection();
		
	}*/
	
	public TecidoDAO () {}
	
	public Connection conectarBanco () {
		
		this.conexao = new ConexaoJdbc();
		this.con = conexao.getConnection();
		
		return con;
	}
	
	public void inserirProduto (Tecido tecido) {
		
		this.con = conectarBanco();
		
		String sql = "INSERT INTO tecido (descricao, preco) VALUES (?, ?)";
		int i = 1; //No exemplo usa int i = 0 e declara i++ no lugar do �ndice "1". N�o entendi o sentido e coloquei 1 direto.
		//Ao acrescentar o atribudot ID no Produto, percebi que precisaria alterar todos os �ndices de todos os m�todos. Com o i++ n�o � necess�rio,
		//altera somente o i.
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			stmt.setString(i++, tecido.getDescricao());
			stmt.setString(i++, tecido.getPreco());
			stmt.execute();
			//con.commit(); //Tirei esse c�digo porque o autocommit est� ligado
			
			JOptionPane.showMessageDialog(null, "Tecido cadastrado com sucesso");
			
		} catch (Exception e) {
			
			System.out.println("Erro ao inserir o tecido: " + e.getMessage());
			
		} finally {
			
			fecharConexao();
			
		}
		
	}
	
	public Tecido consultarTecido (String descricao) throws Exception {
		
		this.con = conectarBanco();
		Tecido tecido = null;
		String sql = "SELECT * FROM tecido WHERE descricao = ?";
		//int idTemp = Integer.valueOf(id); 
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			stmt.setString(1, descricao); //No exemplo usa int i = 0 e declara i++ no lugar do �ndice "1". N�o entendi o sentido e coloquei 1 direto.
			//Ao acrescentar o atribudot ID no Produto, percebi que precisaria alterar todos os �ndices de todos os m�todos. Com o i++ n�o � necess�rio,
			//altera somente o i.
			resultSet = stmt.executeQuery();
						
			while (resultSet.next()) { //Esse resultSet.next est� dentro do while para buscar as colunas de UM registro e n�o v�rios registros
				
				tecido = new Tecido (resultSet.getString("descricao"),
									resultSet.getString("preco"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			fecharConexao();
			
		}
		
		if (tecido == null) {
			
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel localizar o cliente selecionado", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("N�o foi poss�vel localizar o cliente selecionado");
			
		}
		
		return tecido;
		
	}
	
	public ArrayList<Tecido> listarTecidos () throws Exception {
		
		this.con = conectarBanco();
		ArrayList<Tecido> tecidos = new ArrayList<>();
		String sql = "SELECT * FROM tecido";
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				
				tecidos.add(new Tecido(resultSet.getString("descricao"),
						resultSet.getString("preco")));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			fecharConexao();
			
		}
		
		if (tecidos.size() <= 0) {
			
			JOptionPane.showMessageDialog(null, "N�o existem tecidos cadastrados");
			throw new Exception("N�o existem tecidos cadastrados");
			
		}
		
		return tecidos;
		
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
