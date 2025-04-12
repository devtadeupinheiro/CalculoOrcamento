package main;

import java.math.BigDecimal;
import java.util.Scanner;

import model.BrimProfissionalPesado;
import model.CustosPeca;
import model.EscolhaItem;
import model.Produto;

public class Execucao {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Escolha abaixo qual o item:");
		System.out.println("-------MENU-------");
		System.out.println("1 - BATA" + "\n"
						  + "2 - CALÇA" + "\n"
						  + "3 - CAMISA SOCIAL" + "\n"
						  + "4 - CALÇA SOCIAL" + "\n"
						  + "5 - CAMISA POLO" + "\n"
						  + "6 - CAMISA GOLA CARECA" + "\n");
		int opcao = scan.nextInt();
		StringBuilder escolhaItem = new StringBuilder("");
		escolhaItem.append(opcao);
		
		
		switch (opcao) {
			case 1:
				System.out.println("1 - ABERTA" + "\n" + "2 - POLO" + "\n" + "3 - GOLA V");
				opcao = scan.nextInt();
				escolhaItem.append(opcao);
				break;
		}
		
		switch (opcao) {
			case 1:
			System.out.println("1 - MANGA LONGA" + "\n" + "2 - MANGA CURTA");
			opcao = scan.nextInt();
			escolhaItem.append(opcao);
			break;
		}
		
		
		System.out.println(escolhaItem);
		
		EscolhaItem ei = new EscolhaItem(escolhaItem.toString());
		
		//CRIAR UM LOOP PARA IMPEDIR QUE DÊ PROBLEMA COM QUANTIDADE NULA, TIPO ERRADO OU ABAIXO DE 10. ABAIXO DE 10 DA ERRO NOS CALCULOS DE CUSTOSPECA
		System.out.println("Qual a quantidade de peças?");
		opcao = scan.nextInt();
		
		System.out.println("A pintura da frente são quantas cores?" + "\n" + "Digite 0 para nenhuma");
		int pinturaPequena = scan.nextInt();
		
		System.out.println("A pintura das costas são quantas cores?" + "\n" + "Digite 0 para nenhuma");
		int pinturaGrande = scan.nextInt();
		
		//calculo bata aberta manga longa
		if (ei.getCodigo().equals("111")) {
			
			var produto = new Produto();
			produto.tipoManga("mangalonga");
			
			var tecido = new BrimProfissionalPesado();
			
			var calculos = new Calculos();
			BigDecimal preco = calculos.calculo(produto.getConsumoTecido(), produto.getConsumoAviamentos(), produto.getCostureira(), tecido);
			System.out.println(preco.toString() + "preço");
			
			var custosPeca = new CustosPeca();
			String precoTemp = custosPeca.calculoDespesas(opcao, produto);
			BigDecimal custoCorte = custosPeca.custoCorte(opcao);
			System.out.println(precoTemp);
			
			var custoPintura = new BigDecimal(0);
			custoPintura.add(custosPeca.pinturaMaisCores(pinturaPequena, pinturaGrande));
			System.out.println(custoPintura.toString());
			
			var precoProdutoFinal = new BigDecimal(0);
			precoProdutoFinal = precoProdutoFinal.add(preco);
			precoProdutoFinal = precoProdutoFinal.add(new BigDecimal(precoTemp));
			precoProdutoFinal = precoProdutoFinal.add(custoCorte);
			precoProdutoFinal = precoProdutoFinal.add(custoPintura);
			
			System.out.println(precoProdutoFinal.toString());
		}
		
	}

}
