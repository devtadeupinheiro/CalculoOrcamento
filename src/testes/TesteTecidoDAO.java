package testes;

import controller.TecidoDAO;
import model.Tecido;

public class TesteTecidoDAO {
	
	public static void main (String[] args) {
		
		//Teste bem sucedido
		var tecidoDao = new TecidoDAO();
		var tecido = new Tecido();
		tecido.setDescricao("BRIM PROFISSIONAL PESADO");
		tecido.setPreco("18.87");
		
		var tecido1 = new Tecido();
		tecido1.setDescricao("CORINGA");
		tecido1.setPreco("24.50");
		
		var tecido2 = new Tecido();
		tecido2.setDescricao("CEDROPAC");
		tecido2.setPreco("26.50");
		
		tecidoDao.inserirProduto(tecido);
		
		tecidoDao.inserirProduto(tecido1);
		
		tecidoDao.inserirProduto(tecido2);
		
	}

}
