package model;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import strategy.ObterId;
import servicos.ObterAtributos;

public class ModeloTabela extends AbstractTableModel {
	
	private static final String[] colunas = {
			"ID", "Descrição", "Mangas", "Con. Tecido", "Con. Aviamentos", "Costureira", "Acabamento", "Faixas Ref.", "Gola/Punho", "Sug. Preço", "Outras Desc."
	};
	private ArrayList<Produto> produtos;

	public ModeloTabela(ArrayList<Produto> produtos) {
		
		super();
		this.produtos = produtos;
		
	}
	
	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	private final Map<Integer, ObterAtributos> mapStrategy = Map.of (
			
			0, new ObterId()
			
			);
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			
		Produto produto = produtos.get(rowIndex);
		
		if (columnIndex == 0) {
			
			return produto.getId();
			
		} else if (columnIndex == 1) {
			
			return produto.getDescricao();
			
		} else if (columnIndex == 2) {
			
			return produto.getMangas();
			
		} else if (columnIndex == 3) {
			
			return produto.getConsumoTecido();
			
		} else if (columnIndex == 4) {
			
			return produto.getConsumoAviamentos();
			
		} else if (columnIndex == 5) {
			
			return produto.getCostureira();
			
		} else if (columnIndex == 6) {
			
			return produto.getAcabamento();
			
		} else if (columnIndex == 7) {
			
			return produto.getFaixasRefletivas();
			
		} else if (columnIndex == 8) {
			
			return produto.getGolaPunho();
			
		} else if (columnIndex == 9) {
			
			return produto.getSugestaoPreco();
			
		} else if (columnIndex == 10) {
			
			return produto.getOutrasDescricoes();
			
		}
		
		return null;
		//return mapStrategy.get(columnIndex).retornarAtributo(produto, columnIndex);
		
	}

	@Override
	public String getColumnName(int column) {

		return this.colunas[column];
		
	}
	
	

}
