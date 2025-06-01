package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
	private JPrincipal jPrincipal;
	private TableRowSorter<ModeloTabela> rowSorter;

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
		
		this.jPrincipal = this;
		
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
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				var jCadastro = new JCadastro(null, jPrincipal); //Está nulo porque não é para atualização e sim para inclusão. Pois o construtor pede um produto como parametro
				jCadastro.setLocationRelativeTo(jCadastro); //Para abrir no centro
				jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Fecha somente a tela de cadastro ao invés do sistema inteiro
				jCadastro.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(41, 42, 81, 23);
		contentPane.add(btnNewButton);
		
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
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == 1)	{ //1 é o botão esquerdo, 2 o scroll e 3 o botão direito
					
					try {
						
						//Pega a linha selecionada da tabela
						Produto produtoSelecionado = produtoDao.consultarProduto(modeloTabela.getValueAt(table.getSelectedRow(), 0).toString());
						var jCadastro = new JCadastro(produtoSelecionado, jPrincipal);
						jCadastro.setLocationRelativeTo(jCadastro); //Para abrir no centro
						jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Fecha somente a tela de cadastro ao invés do sistema inteiro
						jCadastro.setVisible(true);
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
						
					}
					
				}
				
			}
			
		});
		rowSorter = new TableRowSorter<>(modeloTabela);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);
		
		JButton btnNewButtonVoltar = new JButton("Voltar");
		btnNewButtonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JTelaAbertura.abrirJTelaAbertura(); //Metodo estatico criado em cada tela
				
			}
		});
		btnNewButtonVoltar.setBounds(29, 455, 85, 21);
		contentPane.add(btnNewButtonVoltar);
		
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
