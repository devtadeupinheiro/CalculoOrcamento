package servicos;

import java.math.BigDecimal;

import model.CustosPeca;
import model.Produto;
import model.Tecido;

public class Calculos {
	
	public String descricaoPeca (String nomePeca, String mangas, String tecido, String cor, String outros) {
		StringBuilder descricao = new StringBuilder();
		descricao.append(nomePeca);
		descricao.append(", ");
		descricao.append(mangas);
		descricao.append(", ");
		descricao.append(tecido);
		descricao.append(cor);
		descricao.append(outros);
		
		return descricao.toString();
	}
	
	public static BigDecimal calcularOperacao (String consumoTecido, String consumoAviamentos, String costureira, Tecido tecido) {
		

		BigDecimal primeiroCusto = BigDecimal.ZERO;
		primeiroCusto = primeiroCusto.add(new BigDecimal(consumoTecido));
		System.out.println(primeiroCusto.toString());
		primeiroCusto = primeiroCusto.multiply(new BigDecimal(tecido.getPreco()));
		System.out.println(primeiroCusto.toString());
		primeiroCusto = primeiroCusto.add(new BigDecimal(consumoAviamentos));
		System.out.println(primeiroCusto.toString());
		primeiroCusto = primeiroCusto.add(new BigDecimal(costureira));
		System.out.println(primeiroCusto.toString());
		
		return primeiroCusto;
	}
	
	public BigDecimal calcularProduto (Produto produto, Tecido tecido, int quantidadePecas, int pinturaPequena, int pinturaGrande) {
		
		//var calculos = new Calculos();
		BigDecimal preco = calcularOperacao(produto.getConsumoTecido(), produto.getConsumoAviamentos(), produto.getCostureira(), tecido);

		var custosPeca = new CustosPeca();
		String precoTemp = custosPeca.calculoDespesas(quantidadePecas, produto);
		BigDecimal custoCorte = custosPeca.custoCorte(quantidadePecas);
		
		var custoPintura = new BigDecimal(0);
		custoPintura.add(custosPeca.pinturaMaisCores(pinturaPequena, pinturaGrande));

		var precoProdutoFinal = new BigDecimal(0);
		precoProdutoFinal = precoProdutoFinal.add(preco);
		precoProdutoFinal = precoProdutoFinal.add(new BigDecimal(precoTemp));
		precoProdutoFinal = precoProdutoFinal.add(custoCorte);
		precoProdutoFinal = precoProdutoFinal.add(custoPintura);
		
		return precoProdutoFinal;
	}

}
