package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Produto;

public class ProdutoDAO {
	
	private ConexaoJdbc conexao;
	private Connection con;
	private static PreparedStatement stmt; //Criei fora dos métodos para reaproveitar o método de fechamento da conexão.
	private static ResultSet resultSet;
	
	/*public ProdutoDAO () {
		
		this.conexao = new ConexaoJdbc();
		this.con = conexao.getConnection();
		
	}*/
	
	public ProdutoDAO () {}
	
	public Connection conectarBanco () {
		
		this.conexao = new ConexaoJdbc();
		this.con = conexao.getConnection();
		
		return con;
	}
	
	public void inserirProduto (Produto produto) {
		
		this.con = conectarBanco();
		
		String sql = "INSERT INTO produto (descricao, mangas, consumoTecido, consumoAviamentos, costureira, acabamento, "
				+ "faixasRefletivas, golaPunho, sugestaoPreco, outrasDescricoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int i = 1; //No exemplo usa int i = 0 e declara i++ no lugar do índice "1". Não entendi o sentido e coloquei 1 direto.
		//Ao acrescentar o atribudot ID no Produto, percebi que precisaria alterar todos os índices de todos os métodos. Com o i++ não é necessário,
		//altera somente o i.
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			stmt.setString(i++, produto.getDescricao());
			stmt.setString(i++, produto.getMangas());
			stmt.setString(i++, produto.getConsumoTecido());
			stmt.setString(i++, produto.getConsumoAviamentos());
			stmt.setString(i++, produto.getCostureira());
			stmt.setString(i++, produto.getAcabamento());
			stmt.setString(i++, produto.getFaixasRefletivas());
			stmt.setString(i++, produto.getGolaPunho());
			stmt.setString(i++, produto.getSugestaoPreco());
			stmt.setString(i++, produto.getOutrasDescricoes());
			stmt.execute();
			//con.commit(); //Tirei esse código porque o autocommit está ligado
			
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
			
		} catch (Exception e) {
			
			System.out.println("Erro ao inserir o produto: " + e.getMessage());
			
		} finally {
			
			fecharConexao();
			
		}
		
	}
	
	public Produto consultarProduto (String id) throws Exception {
		
		this.con = conectarBanco();
		Produto produto = null;
		String sql = "SELECT * FROM produto WHERE id = ?";
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			stmt.setString(1, id); //No exemplo usa int i = 0 e declara i++ no lugar do índice "1". Não entendi o sentido e coloquei 1 direto.
			//Ao acrescentar o atribudot ID no Produto, percebi que precisaria alterar todos os índices de todos os métodos. Com o i++ não é necessário,
			//altera somente o i.
			resultSet = stmt.executeQuery();
						
			while (resultSet.next()) { //Esse resultSet.next está dentro do while para buscar as colunas de UM registro e não vários registros
				
				produto = new Produto (resultSet.getInt("ID"),
									resultSet.getString("descricao"),
									resultSet.getString("mangas"),
									resultSet.getString("consumotecido"),
									resultSet.getString("consumoaviamentos"),
									resultSet.getString("costureira"),
									resultSet.getString("acabamento"),
									resultSet.getString("faixasrefletivas"),
									resultSet.getString("golapunho"),
									resultSet.getString("sugestaopreco"),
									resultSet.getString("outrasdescricoes"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			fecharConexao();
			
		}
		
		if (produto == null) {
			
			JOptionPane.showMessageDialog(null, "Não foi possível localizar o cliente selecionado", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possível localizar o cliente selecionado");
			
		}
		
		return produto;
		
	}
	
	public void alterarProduto (int id, Produto produto) {
		
		this.con = conectarBanco();
		String sql = "UPDATE produto SET descricao = ?, mangas = ?, consumotecido = ?, consumoaviamentos = ?, costureira = ?, "
				+ "acabamento = ?, faixasrefletivas = ?, golapunho = ?, sugestaopreco = ?, outrasdescricoes = ? "
				+ "WHERE id = ?";
		int i = 1; //No exemplo usa int i = 0 e declara i++ no lugar do índice "1". Não entendi o sentido e coloquei 1 direto.
		//Ao acrescentar o atribudot ID no Produto, percebi que precisaria alterar todos os índices de todos os métodos. Com o i++ não é necessário,
		//altera somente o i.
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			stmt.setString(i++, produto.getDescricao());
			stmt.setString(i++, produto.getMangas());
			stmt.setString(i++, produto.getConsumoTecido());
			stmt.setString(i++, produto.getConsumoAviamentos());
			stmt.setString(i++, produto.getCostureira());
			stmt.setString(i++, produto.getAcabamento());
			stmt.setString(i++, produto.getFaixasRefletivas());
			stmt.setString(i++, produto.getGolaPunho());
			stmt.setString(i++, produto.getSugestaoPreco());
			stmt.setString(i++, produto.getOutrasDescricoes());
			stmt.execute();
			con.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			fecharConexao();
			
		}
		
	}
	
	public void excluirProduto (int id) {
		
		this.con = conectarBanco();
		String sql = "DELETE produto WHERE id = ?";
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			con.commit();
			
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			fecharConexao();
			
		}
		
	}
	
	public ArrayList<Produto> listarClientes () throws Exception {
		
		this.con = conectarBanco();
		ArrayList<Produto> clientes = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		
		try {
			
			stmt = this.con.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				
				clientes.add(new Produto(resultSet.getInt("ID"),
						resultSet.getString("descricao"),
						resultSet.getString("mangas"),
						resultSet.getString("consumotecido"),
						resultSet.getString("consumoaviamentos"),
						resultSet.getString("costureira"),
						resultSet.getString("acabamento"),
						resultSet.getString("faixasrefletivas"),
						resultSet.getString("golapunho"),
						resultSet.getString("sugestaopreco"),
						resultSet.getString("outrasdescricoes")));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			fecharConexao();
			
		}
		
		if (clientes.size() <= 0) {
			
			JOptionPane.showMessageDialog(null, "Não existem clientes cadastrados");
			throw new Exception("Não existem clientes cadastrados");
			
		}
		
		return clientes;
		
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
