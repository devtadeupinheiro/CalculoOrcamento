package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO {
	
	private ConexaoJdbc conexao;
	private Connection con;
	
	public ProdutoDAO () {
		
		this.conexao = new ConexaoJdbc();
		this.con = conexao.getConnection();
		
	}
	
	public void inserirProduto (Produto produto) {
		
		String sql = "INSERT INTO produto (descricao, mangas, consumoTecido, consumoAviamentos, costureira, acabamento, "
				+ "faixasRefletivas, golaPunho, sugestaoPreco, outrasDescricoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getMangas());
			stmt.setString(3, produto.getConsumoTecido());
			stmt.setString(4, produto.getConsumoAviamentos());
			stmt.setString(5, produto.getCostureira());
			stmt.setString(6, produto.getAcabamento());
			stmt.setString(7, produto.getFaixasRefletivas());
			stmt.setString(8, produto.getGolaPunho());
			stmt.setString(9, produto.getSugestaoPreco());
			stmt.setString(10, produto.getOutrasDescricoes());
			stmt.execute();
			
			
			
		} catch (Exception e) {
			
			System.out.println("Erro ao inserir o produto: " + e.getMessage());
			
		}
		
	}

}
