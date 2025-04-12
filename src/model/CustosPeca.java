package model;

import java.math.BigDecimal;

public class CustosPeca {
	
	private String imposto = "0.065";
	private double corte = 0.05;
	private double logistica = 1;
	private double baseCalculoFaturamento = 50000;
	private double contabilidade = 350;
	private double energia = 300;
	private double agua = 300;
	private long prolabore = 7000;
	private double pinturaPequena = 0.7;
	private double pinturaGrande = 0.95;
	private double adicaoPinturaPequena = 0.05;
	private double adicaoPinturaGrande = 0.1;
	
	public BigDecimal pinturaMaisCores (int quantidadeCoresPequena, int quantidadeCoresGrande) {
		
		if (quantidadeCoresPequena == 0 && quantidadeCoresGrande == 0) {
			
			return new BigDecimal(0);
			
		} else {
			
			pinturaGrande = this.pinturaGrande;
			pinturaPequena = this.pinturaPequena;
			
			if (quantidadeCoresPequena > 1) {
				
				pinturaPequena += (quantidadeCoresPequena-1) * adicaoPinturaPequena;
				
			}
			
			if (quantidadeCoresGrande > 1) {
				
				pinturaGrande += (quantidadeCoresGrande-1) * adicaoPinturaGrande;
				
			}
			
		}
		
		var pinturaTotal = pinturaGrande + pinturaPequena;
		
		return new BigDecimal(pinturaTotal);
		
	}
	
	public String calculoDespesas (int quantidadePecas, Produto peca) {
		
		BigDecimal sugestaoPrecoProduto = new BigDecimal(peca.getSugestaoPreco());
		var qtdPecas = new BigDecimal(quantidadePecas);
		
		BigDecimal totalItem = BigDecimal.ZERO;
		totalItem = totalItem.add(sugestaoPrecoProduto.multiply(qtdPecas));
		System.out.println(totalItem.toString() + "CustosPecas.calculoDespesas/totalItem");
		
		var despesas = new BigDecimal(contabilidade);
		despesas = despesas.add(new BigDecimal(agua));
		despesas = despesas.add(new BigDecimal(energia));
		despesas = despesas.divide(new BigDecimal(baseCalculoFaturamento));
		
		despesas = despesas.multiply(totalItem);
		despesas = despesas.divide(qtdPecas);
		
		var prolabore = new BigDecimal(this.prolabore);
		prolabore = prolabore.divide(new BigDecimal(baseCalculoFaturamento));
		prolabore = prolabore.multiply(sugestaoPrecoProduto);
		
		var acabamento = new BigDecimal(peca.getAcabamento());
		
		var faixasRefletivas = new BigDecimal(peca.getFaixasRefletivas());
		
		var logistica = new BigDecimal(this.logistica);
		
		var impostoFinal = new BigDecimal(0);
		impostoFinal = impostoFinal.add(sugestaoPrecoProduto.multiply(new BigDecimal(imposto)));
		
		var consumoTecido = BigDecimal.ZERO;
		
		var precoFinal = BigDecimal.ZERO;
		precoFinal = precoFinal.add(despesas);
		precoFinal = precoFinal.add(prolabore);
		precoFinal = precoFinal.add(acabamento);
		precoFinal = precoFinal.add(faixasRefletivas);
		precoFinal = precoFinal.add(logistica);
		precoFinal = precoFinal.add(impostoFinal);
		
		return precoFinal.toString();
		
	}
	
	public BigDecimal custoCorte (int quantidadePecas) {
		
		var corte = new BigDecimal(10);

		//10 a 20 = R$ 10,00
		if (quantidadePecas > 0 && quantidadePecas < 11) {
			
			return corte;
		
		//20 a 30 = R$ 7,00
		} else if (quantidadePecas > 10 && quantidadePecas < 21) {
			
			return corte = corte.subtract(new BigDecimal(3));
			
		//30 a 40 = R$ 5,00	
		} else if (quantidadePecas > 20 && quantidadePecas < 31) {
			
			return corte = corte.subtract(new BigDecimal(5));
		
		//40 a 50 = R$ 4,00	
		} else if (quantidadePecas > 30 && quantidadePecas < 51) {
			
			return corte = corte.subtract(new BigDecimal(6));
			
		//Acima de 50 = R$ 3,00	
		} else if (quantidadePecas > 50) {
			
			return corte = corte.subtract(new BigDecimal(7));
			
		}
		
		return BigDecimal.ZERO;
		
		
	}

}
