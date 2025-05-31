package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Produto;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class JCalculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_id;
	private JTextField textField_descricao;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		/*
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
		*/
	}
	
	
}
