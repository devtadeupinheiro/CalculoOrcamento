package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProdutoDAO;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDescricao;
	private JTextField textFieldMangas;
	private JTextField textFieldConsumoTecido;
	private JTextField textFieldCostureira;
	private JTextField textFieldAcabamento;
	private JLabel lblFaixasRefletivas;
	private JTextField textFieldFaixasRefletivas;
	private JLabel lblGolaPunho;
	private JTextField textFieldGolaPunho;
	private JLabel lblSugestoR;
	private JTextField textFieldSugestaoPreco;
	private JLabel lblOutrasDescricoes;
	private JTextField textFieldOutrasDescricoes;
	private JTextField textFieldConsumoAviamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro frame = new JCadastro(null, null);
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
	public JCadastro(Produto produtoSelecionado, JPrincipal jPrincipal) {
		
		var produtoDAO = new ProdutoDAO();
		
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
		
		JLabel lblConsumoAviamentos = new JLabel("Consumo Aviamentos");
		lblConsumoAviamentos.setBounds(308, 66, 116, 14);
		contentPane.add(lblConsumoAviamentos);
		
		textFieldConsumoAviamentos = new JTextField();
		textFieldConsumoAviamentos.setColumns(10);
		textFieldConsumoAviamentos.setBounds(308, 91, 116, 20);
		contentPane.add(textFieldConsumoAviamentos);	
		
		JLabel lblCostureira = new JLabel("Costureira");
		lblCostureira.setBounds(32, 125, 86, 14);
		contentPane.add(lblCostureira);
		
		textFieldCostureira = new JTextField();
		textFieldCostureira.setColumns(10);
		textFieldCostureira.setBounds(32, 150, 86, 20);
		contentPane.add(textFieldCostureira);
		
		JLabel lblAcabamento = new JLabel("Acabamento");
		lblAcabamento.setBounds(134, 125, 86, 14);
		contentPane.add(lblAcabamento);
		
		textFieldAcabamento = new JTextField();
		textFieldAcabamento.setColumns(10);
		textFieldAcabamento.setBounds(134, 150, 86, 20);
		contentPane.add(textFieldAcabamento);
		
		lblFaixasRefletivas = new JLabel("Faixas Refletivas");
		lblFaixasRefletivas.setBounds(230, 125, 92, 14);
		contentPane.add(lblFaixasRefletivas);
		
		textFieldFaixasRefletivas = new JTextField();
		textFieldFaixasRefletivas.setColumns(10);
		textFieldFaixasRefletivas.setBounds(230, 150, 92, 20);
		contentPane.add(textFieldFaixasRefletivas);
		
		lblGolaPunho = new JLabel("Gola/Punho");
		lblGolaPunho.setBounds(338, 125, 86, 14);
		contentPane.add(lblGolaPunho);
		
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
		
		lblOutrasDescricoes = new JLabel("Outras Descri\u00E7\u00F5es");
		lblOutrasDescricoes.setBounds(128, 181, 296, 14);
		contentPane.add(lblOutrasDescricoes);
		
		textFieldOutrasDescricoes = new JTextField();
		textFieldOutrasDescricoes.setColumns(10);
		textFieldOutrasDescricoes.setBounds(128, 206, 296, 44);
		contentPane.add(textFieldOutrasDescricoes);
		
		//Passando teste direto no parametro se for nulo "cadastrar" se nao "Alterar"
		JButton btnNewButtonCadastrar = new JButton(produtoSelecionado==null?"Cadastrar":"Alterar");
		btnNewButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto produto = new Produto(textFieldDescricao.getText(), textFieldMangas.getText(), 
						textFieldConsumoTecido.getText(), textFieldConsumoAviamentos.getText(),
						textFieldCostureira.getText(), textFieldAcabamento.getText(),
						textFieldFaixasRefletivas.getText(), textFieldGolaPunho.getText(),
						textFieldSugestaoPreco.getText(), textFieldOutrasDescricoes.getText());

				if (produtoSelecionado == null) {
					
					if (!textFieldDescricao.getText().isBlank() && !textFieldMangas.getText().isBlank() && 
						!textFieldConsumoTecido.getText().isBlank() && !textFieldConsumoAviamentos.getText().isBlank() &&
						!textFieldCostureira.getText().isBlank() && !textFieldAcabamento.getText().isBlank() &&
						!textFieldFaixasRefletivas.getText().isBlank() && !textFieldGolaPunho.getText().isBlank() &&
						!textFieldSugestaoPreco.getText().isBlank() && !textFieldOutrasDescricoes.getText().isBlank()) {
					
						produtoDAO.inserirProduto(produto);
						abrirTelaPrincipal(jPrincipal);
						
					} else {
						
						JOptionPane.showMessageDialog(null,"Existem campos vazios");
						
					}
								
				} else {
					
					if (!textFieldDescricao.getText().isBlank() && !textFieldMangas.getText().isBlank() && 
							!textFieldConsumoTecido.getText().isBlank() && !textFieldConsumoAviamentos.getText().isBlank() &&
							!textFieldCostureira.getText().isBlank() && !textFieldAcabamento.getText().isBlank() &&
							!textFieldFaixasRefletivas.getText().isBlank() && !textFieldGolaPunho.getText().isBlank() &&
							!textFieldSugestaoPreco.getText().isBlank() && !textFieldOutrasDescricoes.getText().isBlank()) {
						
							//NÃO ESTÁ ATUALIZANDO NA HORA NA TELA DE JPRINCIPAL. SO QUANDO FECHA E ABRE NOVAMENTE
							produto.setId(produtoSelecionado.getId());
							produtoDAO.alterarProduto(produtoSelecionado.getId(), produto);
							abrirTelaPrincipal(jPrincipal);
							
						} else {
							
							JOptionPane.showMessageDialog(null,"Existem campos vazios");
							
						}
					
				}
				
			}
		});
		
		btnNewButtonCadastrar.setBounds(308, 284, 116, 23);
		contentPane.add(btnNewButtonCadastrar);
		
		JButton btnNewButtonExcluir = new JButton("Excluir");
		
		btnNewButtonExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				produtoDAO.excluirProduto(produtoSelecionado.getId());
				abrirTelaPrincipal(jPrincipal);
				
			}
			
		});
		
		btnNewButtonExcluir.setForeground(new Color(255, 255, 255));
		btnNewButtonExcluir.setBackground(new Color(255, 0, 0));
		btnNewButtonExcluir.setBounds(32, 284, 116, 23);
		btnNewButtonExcluir.setVisible(false);
		contentPane.add(btnNewButtonExcluir);
		
		if (produtoSelecionado != null) {
			
			preencherCampos(produtoSelecionado);
			btnNewButtonExcluir.setVisible(true);
			
		}
		
		
	}
	
	public void preencherCampos (Produto produtoSelecionado) {
		
		textFieldDescricao.setText(produtoSelecionado.getDescricao());
		textFieldMangas.setText(produtoSelecionado.getMangas());
		textFieldConsumoTecido.setText(produtoSelecionado.getConsumoTecido());
		textFieldConsumoAviamentos.setText(produtoSelecionado.getConsumoAviamentos());
		textFieldCostureira.setText(produtoSelecionado.getCostureira());
		textFieldAcabamento.setText(produtoSelecionado.getAcabamento());
		textFieldFaixasRefletivas.setText(produtoSelecionado.getFaixasRefletivas());
		textFieldGolaPunho.setText(produtoSelecionado.getGolaPunho());
		textFieldSugestaoPreco.setText(produtoSelecionado.getSugestaoPreco());
		textFieldOutrasDescricoes.setText(produtoSelecionado.getOutrasDescricoes());
		
	}
	
	private void abrirTelaPrincipal (JPrincipal jPrincipal) {
		
		jPrincipal.dispose();
		dispose();
		jPrincipal = new JPrincipal();
		jPrincipal.setLocationRelativeTo(jPrincipal);
		jPrincipal.setVisible(true);
		
	}
	
}
