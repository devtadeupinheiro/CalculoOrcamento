package testes;

import controller.*;
import main.Calculos;
import model.*;
public class TesteProdutoDAO {
	
	public static void main (String[] args) {
		
		var produtoPersistencia = new ProdutoDAO();
		var produtoTeste = new Produto();
		
		//TESTE INCLUIR PRODUTO
		/*produtoTeste.setDescricao("BATA MODELO ABERTA");
		produtoTeste.setMangas("MANGA LONGA");
		produtoTeste.setConsumoTecido("1.4");
		produtoTeste.setConsumoAviamentos("1.22");
		produtoTeste.setCostureira("4.5");
		produtoTeste.setAcabamento("2.18");
		produtoTeste.setFaixasRefletivas("3.3");
		produtoTeste.setGolaPunho("0");
		produtoTeste.setSugestaoPreco("75.9");
		produtoTeste.setOutrasDescricoes("Gola simples, fechamento frontal em 5 botões transparentes,"
		+ "com protetor de botões, 1 bolso sobreposto no peito esquerdo, 2 bolsos sobrepostos inferiores");
		
		
		produtoPersistencia.inserirProduto(produtoTeste);
		System.out.println(produtoTeste.toString());		
		*/
		
		//TESTE CONSULTA PRODUTO
		/*
		try {
			
			produtoTeste = produtoPersistencia.consultarProduto("8");
			System.out.println(produtoTeste.toString());
			
		} catch (PSQLException e) {
			
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		*/
		
		//TESTE EXCLUIR PRODUTO
		/*
		try {
			
			produtoPersistencia.excluirProduto(9);
						
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		*/
		
	}

}
