package view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import controller.ProdutoDAO;
import model.ModeloTabelaCalculo;
import model.Produto;

public class JSelecionar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Produto> produtos;
	private JTable table;
	private TableRowSorter<ModeloTabelaCalculo> rowSorter;
	private JSelecionar jCalculo;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSelecionar frame = new JSelecionar();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JSelecionar() {
		
		this.jCalculo = this;
		
		var produtoDao = new ProdutoDAO();
		
		try {
			
			produtos = produtoDao.listarClientes();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			
			public void keyPressed (KeyEvent e) {
				
				filtrar();
				
			}
			
		});
		textField.setBounds(144, 43, 491, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 822, 291);
		contentPane.add(scrollPane);
		
		var modeloTabelaCalculo = new ModeloTabelaCalculo(this.produtos);
		
		table = new JTable();
		table.setModel(modeloTabelaCalculo);
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == 1)	{ //1 é o botão esquerdo, 2 o scroll e 3 o botão direito
					
					try {
						
						//Pega a linha selecionada da tabela
						Produto produtoSelecionado = produtoDao.consultarProduto(modeloTabelaCalculo.getValueAt(table.getSelectedRow(), 0).toString());
						var jCalculo = new JCalculo(produtoSelecionado);
						jCalculo.setLocationRelativeTo(jCalculo); //Para abrir no centro
						jCalculo.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Fecha somente a tela de cadastro ao invés do sistema inteiro
						jCalculo.setVisible(true);
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
						
					}
					
				}
				
			}
			
		});
		
		rowSorter = new TableRowSorter<>(modeloTabelaCalculo);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);
	}
	
	private void filtrar() {
		
		String busca = textField.getText().trim();
		
		if (busca.length() == 0) {
			
			rowSorter.setRowFilter(null);
			
		} else {
			
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + busca));
			
		}
		
	}
	
}
