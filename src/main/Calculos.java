package main;

import java.math.BigDecimal;

import model.BrimProfissionalPesado;

public class Calculos {
	
	private String numeroOrcamento = "1"; //CRIAR UM ID DEPOIS COM BANCO DE DADOS
	
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
	
	//criar classe para colocar despesas para incluir no calculo
	//usar outra classe para numeros financeiros porque double da imprecisao
	public BigDecimal calculo (String consumoTecido, String consumoAviamentos, String costureira, BrimProfissionalPesado tecido) {
		

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

}
