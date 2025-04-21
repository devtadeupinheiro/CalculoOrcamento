package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoDAO;
import model.ModeloTabela;
import model.Produto;

import javax.swing.JScrollPane;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ArrayList<Produto> produtos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {
		
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
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(41, 42, 81, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(144, 43, 491, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 822, 291);
		contentPane.add(scrollPane);
		
		ModeloTabela modeloTabela = new ModeloTabela(this.produtos);
		
		table = new JTable();
		table.setModel(modeloTabela);
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Mangas", "Con. Tecido", "Con. Aviamentos", "Costureira", "Acabamento", "Faixas Ref.", "Gola/Punho", "Sug. Preço", "Outras Desc."
			}
		));*/
		scrollPane.setViewportView(table);
	}
}
