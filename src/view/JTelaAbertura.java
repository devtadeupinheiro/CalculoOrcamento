package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JTelaAbertura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelaAbertura frame = new JTelaAbertura();
					frame.setLocationRelativeTo(frame);
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
	public JTelaAbertura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButtonCalcular = new JButton("C\u00E1lculo");
		btnNewButtonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose(); //FECHA A TELA ATUAL E ABRE A PRÓXIMA
				JSelecionar jSelecionar = new JSelecionar();
				jSelecionar.setLocationRelativeTo(jSelecionar);
				jSelecionar.setVisible(true);
				
			}
		});
		btnNewButtonCalcular.setBounds(10, 11, 174, 23);
		contentPane.add(btnNewButtonCalcular);
		
		JButton btnCadastraralterar = new JButton("Cadastrar/Alterar");
		btnCadastraralterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose(); //FECHA A TELA ATUAL E ABRE A PRÓXIMA
				JPrincipal jPrincipal = new JPrincipal();
				jPrincipal.setLocationRelativeTo(jPrincipal);
				jPrincipal.setVisible(true);
				
			}
		});
		btnCadastraralterar.setBounds(250, 11, 174, 23);
		contentPane.add(btnCadastraralterar);
		
		
	}
	
	public static void abrirJTelaAbertura () {
		
		JTelaAbertura jTelaAbertura = new JTelaAbertura();
		jTelaAbertura.setLocationRelativeTo(jTelaAbertura);
		jTelaAbertura.setVisible(true);
		
	}
}
