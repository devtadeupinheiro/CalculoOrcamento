package testes;

import model.CustosPeca;
import model.Produto;

public class CustosPecaTeste {
	
	public static void main (String[] args) {
		
		var custosPecas = new CustosPeca();
		var bataaberta = new Produto();
		bataaberta.tipoManga("mangalonga");
		
		
		String retornoCalculoDespesas = custosPecas.calculoDespesas(20, bataaberta);
		System.out.println(retornoCalculoDespesas);
		
		String retornoPinturaMaisCores = custosPecas.pinturaMaisCores(2, 2);
		System.out.println(retornoPinturaMaisCores);
		
	}

}
