package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProdutoDAO;
import controller.TecidoDAO;
import main.Execucao;
import model.Produto;
import model.Tecido;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class JCalculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_id;
	private JTextField textField_descricao;
	private JTextField textFieldQuantidadePecas;
	private JTextField textFieldQuantidadeCoresP;
	private JTextField textFieldQuantidadeCoresG;
	private ArrayList<Tecido> tecidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculo frame = new JCalculo(null);
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
	public JCalculo(Produto produtoSelecionado) {
		
		var tecidoDao = new TecidoDAO();
		
		try {
			
			tecidos = tecidoDao.listarTecidos();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		
	}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(tecidos.toArray());
		comboBox.setBounds(216, 254, 305, 21);
		contentPane.add(comboBox);
		
		textField_id = new JTextField();
		textField_id.setBounds(10, 33, 61, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabelId = new JLabel("ID");
		lblNewLabelId.setBounds(10, 11, 61, 14);
		contentPane.add(lblNewLabelId);
		
		textField_descricao = new JTextField();
		textField_descricao.setColumns(10);
		textField_descricao.setBounds(81, 33, 716, 94);
		contentPane.add(textField_descricao);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(81, 11, 716, 14);
		contentPane.add(lblDescrio);
		
		JButton btnNewButtonVoltar = new JButton("Voltar");
		btnNewButtonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JSelecionar.abrirJSelecionar(); //Metodo estatico criado em cada tela
				
			}
		});
		btnNewButtonVoltar.setBounds(29, 455, 85, 21);
		contentPane.add(btnNewButtonVoltar);
		

		JLabel lblQuantidade = new JLabel("Quantidade de Pe\u00E7as");
		lblQuantidade.setBounds(10, 166, 196, 14);
		contentPane.add(lblQuantidade);
		
		textFieldQuantidadePecas = new JTextField();
		textFieldQuantidadePecas.setColumns(10);
		textFieldQuantidadePecas.setBounds(216, 164, 61, 20);
		contentPane.add(textFieldQuantidadePecas);
		
		JLabel lblCoresFrente = new JLabel("Quant. Cores Pintura Pequena");
		lblCoresFrente.setBounds(10, 196, 196, 14);
		contentPane.add(lblCoresFrente);
		
		textFieldQuantidadeCoresP = new JTextField();
		textFieldQuantidadeCoresP.setColumns(10);
		textFieldQuantidadeCoresP.setBounds(216, 194, 61, 20);
		contentPane.add(textFieldQuantidadeCoresP);
		
		JLabel lblPinturaG = new JLabel("Quant. Cores Pintura Grande");
		lblPinturaG.setBounds(10, 226, 196, 14);
		contentPane.add(lblPinturaG);
		
		textFieldQuantidadeCoresG = new JTextField();
		textFieldQuantidadeCoresG.setColumns(10);
		textFieldQuantidadeCoresG.setBounds(216, 224, 61, 20);
		contentPane.add(textFieldQuantidadeCoresG);
		
		JLabel lblTecido = new JLabel("Tecido");
		lblTecido.setBounds(10, 254, 196, 14);
		contentPane.add(lblTecido);
		
		
		JButton btnNewButtonCalcular = new JButton("Calcular");
		btnNewButtonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int quantPecas = 0;
				int quantCoresP = 0;
				int quantCoresG = 0;
				
				if (!textFieldQuantidadePecas.getText().isBlank() || !textFieldQuantidadeCoresP.getText().isBlank() || !textFieldQuantidadeCoresG.getText().isBlank()) {
						
					try {
						
						quantPecas = Integer.parseInt(textFieldQuantidadePecas.getText());
						quantCoresP = Integer.parseInt(textFieldQuantidadeCoresP.getText());
						quantCoresG = Integer.parseInt(textFieldQuantidadeCoresG.getText());
						
						//SELECIONAR O TECIDO				
						int indiceSelecionado = comboBox.getSelectedIndex();
						var tecidoSelecionado = new Tecido();
						var execucaoCalculos = new Execucao();
						try {
							
							tecidoSelecionado = tecidoDao.consultarTecido(tecidos.get(indiceSelecionado).getDescricao());
							
							BigDecimal precoProduto = execucaoCalculos.calcularProduto(produtoSelecionado, tecidoSelecionado, quantPecas, quantCoresP, quantCoresG);
							JOptionPane.showMessageDialog(btnNewButtonCalcular, "O preço do produto é: R$ " + precoProduto.toString());
							
						} catch (Exception e1) {
							
							JOptionPane.showMessageDialog(btnNewButtonCalcular, "Não foi possível localizar o tecido selecionado");
							e1.printStackTrace();
						}
						
					} catch (NumberFormatException e1) {
						
						JOptionPane.showMessageDialog(btnNewButtonCalcular, "Preencher campos somente com números");
						System.out.println(e1.getMessage());
						
					} catch (Exception e2) {
						
						System.out.println(e2.getMessage());
						
					}
					
				}
				
				dispose();
				
			}
		});
		btnNewButtonCalcular.setBounds(130, 455, 85, 21);
		contentPane.add(btnNewButtonCalcular);
		
		
		if (produtoSelecionado != null) {
			
			preencherCampos(produtoSelecionado);
			
		}
		
		
		
	}
	
	public void preencherCampos (Produto produtoSelecionado) {
		
		
		textField_id.setText(String.valueOf(produtoSelecionado.getId()));
		StringBuilder sb = new StringBuilder();
		sb.append(produtoSelecionado.getDescricao());
		sb.append(", ");
		sb.append(produtoSelecionado.getMangas());
		sb.append(", ");
		sb.append(produtoSelecionado.getOutrasDescricoes());
		
		
		textField_descricao.setText(sb.toString());
		
	}
}
