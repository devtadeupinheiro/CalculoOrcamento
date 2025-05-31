package model;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import servicos.ObterAtributos;
import strategy.ObterId;

public class ModeloTabelaCalculo extends AbstractTableModel {

	private static final String[] colunas = {
			"ID", "Descrição", "Mangas", "Outras Desc."
	};
	private ArrayList<Produto> produtos;

	public ModeloTabelaCalculo(ArrayList<Produto> produtos) {
		
		super();
		this.produtos = produtos;
		
	}
	
	public int getRowCount() {
		return produtos.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	private final Map<Integer, ObterAtributos> mapStrategy = Map.of (
			
			0, new ObterId()
			
			);
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Produto produto = produtos.get(rowIndex);
		
		if (columnIndex == 0) {
			
			return produto.getId();
			
		} else if (columnIndex == 1) {
			
			return produto.getDescricao();
			
		} else if (columnIndex == 2) {
			
			return produto.getMangas();
			
		} else if (columnIndex == 3) {
			
			return produto.getOutrasDescricoes();
			
		}
		
		return null;
		//return mapStrategy.get(columnIndex).retornarAtributo(produto, columnIndex);
		
	}

	public String getColumnName(int column) {

		return this.colunas[column];
		
	}
	
	

}
