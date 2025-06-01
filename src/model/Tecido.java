package model;

public class Tecido {
	
	private String descricao;
	private String preco;
	
	public Tecido() {};
	
	public Tecido (String descricao, String preco) {
		
		this.descricao = descricao;
		this.preco = preco;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return descricao;
	}
	
	
	

}
