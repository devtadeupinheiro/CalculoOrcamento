package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {
	
	private static final String[] colunas = {
			"Descri��o", "Mangas", "Con. Tecido", "Con. Aviamentos", "Costureira", "Acabamento", "Faixas Ref.", "Gola/Punho", "Sug. Pre�o", "Outras Desc."
	};
	
	private ArrayList<Produto> produtos;

	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			
		Produto produto = produtos.get(rowIndex);
		
		return null;
	}

}
