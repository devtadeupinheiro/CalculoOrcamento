package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProdutoDAO;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDescricao;
	private JTextField textFieldMangas;
	private JTextField textFieldConsumoTecido;
	private JTextField textFieldCostureira;
	private JTextField textFieldAcabamento;
	private JLabel lblCostureira_2;
	private JTextField textFieldFaixasRefletivas;
	private JLabel lblCostureira_3;
	private JTextField textFieldGolaPunho;
	private JLabel lblSugestoR;
	private JTextField textFieldSugestaoPreco;
	private JLabel lblCostureira_5;
	private JTextField textFieldOutrasDescricoes;
	private JTextField textFieldConsumoAviamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro frame = new JCadastro(null);
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
	public JCadastro(Produto produtoSelecionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel.setBounds(32, 10, 137, 14);
		contentPane.add(lblNewLabel);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(32, 35, 392, 20);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JLabel lblMangas = new JLabel("Mangas");
		lblMangas.setBounds(32, 66, 46, 14);
		contentPane.add(lblMangas);
		
		textFieldMangas = new JTextField();
		textFieldMangas.setColumns(10);
		textFieldMangas.setBounds(32, 91, 137, 20);
		contentPane.add(textFieldMangas);
		
		JLabel lblConsumoTecido = new JLabel("Consumo Tecido");
		lblConsumoTecido.setBounds(179, 66, 116, 14);
		contentPane.add(lblConsumoTecido);
		
		textFieldConsumoTecido = new JTextField();
		textFieldConsumoTecido.setColumns(10);
		textFieldConsumoTecido.setBounds(179, 91, 116, 20);
		contentPane.add(textFieldConsumoTecido);
		
		JLabel lblCostureira = new JLabel("Costureira");
		lblCostureira.setBounds(32, 125, 86, 14);
		contentPane.add(lblCostureira);
		
		textFieldCostureira = new JTextField();
		textFieldCostureira.setColumns(10);
		textFieldCostureira.setBounds(32, 150, 86, 20);
		contentPane.add(textFieldCostureira);
		
		JLabel lblCostureira_1 = new JLabel("Acabamento");
		lblCostureira_1.setBounds(134, 125, 86, 14);
		contentPane.add(lblCostureira_1);
		
		textFieldAcabamento = new JTextField();
		textFieldAcabamento.setColumns(10);
		textFieldAcabamento.setBounds(134, 150, 86, 20);
		contentPane.add(textFieldAcabamento);
		
		lblCostureira_2 = new JLabel("Faixas Refletivas");
		lblCostureira_2.setBounds(230, 125, 92, 14);
		contentPane.add(lblCostureira_2);
		
		textFieldFaixasRefletivas = new JTextField();
		textFieldFaixasRefletivas.setColumns(10);
		textFieldFaixasRefletivas.setBounds(230, 150, 92, 20);
		contentPane.add(textFieldFaixasRefletivas);
		
		lblCostureira_3 = new JLabel("Gola/Punho");
		lblCostureira_3.setBounds(338, 125, 86, 14);
		contentPane.add(lblCostureira_3);
		
		textFieldGolaPunho = new JTextField();
		textFieldGolaPunho.setColumns(10);
		textFieldGolaPunho.setBounds(338, 150, 86, 20);
		contentPane.add(textFieldGolaPunho);
		
		lblSugestoR = new JLabel("Sugest\u00E3o R$");
		lblSugestoR.setBounds(32, 181, 86, 14);
		contentPane.add(lblSugestoR);
		
		textFieldSugestaoPreco = new JTextField();
		textFieldSugestaoPreco.setColumns(10);
		textFieldSugestaoPreco.setBounds(32, 206, 86, 20);
		contentPane.add(textFieldSugestaoPreco);
		
		lblCostureira_5 = new JLabel("Outras Descri\u00E7\u00F5es");
		lblCostureira_5.setBounds(128, 181, 296, 14);
		contentPane.add(lblCostureira_5);
		
		textFieldOutrasDescricoes = new JTextField();
		textFieldOutrasDescricoes.setColumns(10);
		textFieldOutrasDescricoes.setBounds(128, 206, 296, 44);
		contentPane.add(textFieldOutrasDescricoes);
		
		//Passando teste direto no parametro se for nulo "cadastrar" se nao "Alterar"
		JButton btnNewButtonCadastrar = new JButton(produtoSelecionado==null?"Cadastrar":"Alterar");
		btnNewButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				var produtoDAO = new ProdutoDAO();
				produtoDAO.inserirProduto(new Produto(textFieldDescricao.getText(), textFieldMangas.getText(), 
										textFieldConsumoTecido.getText(), textFieldConsumoAviamentos.getText(),
										textFieldCostureira.getText(), textFieldAcabamento.getText(),
										textFieldFaixasRefletivas.getText(), textFieldGolaPunho.getText(),
										textFieldSugestaoPreco.getText(), textFieldOutrasDescricoes.getText()));
				
			}
		});
		btnNewButtonCadastrar.setBounds(308, 284, 116, 23);
		contentPane.add(btnNewButtonCadastrar);
		
		JLabel lblConsumoAviamentos = new JLabel("Consumo Aviamentos");
		lblConsumoAviamentos.setBounds(308, 66, 116, 14);
		contentPane.add(lblConsumoAviamentos);
		
		textFieldConsumoAviamentos = new JTextField();
		textFieldConsumoAviamentos.setColumns(10);
		textFieldConsumoAviamentos.setBounds(308, 91, 116, 20);
		contentPane.add(textFieldConsumoAviamentos);
	}
}
