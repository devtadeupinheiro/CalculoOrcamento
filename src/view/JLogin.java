package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setLocationRelativeTo(null); //Para a tela abrir no centro
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
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(83, 83, 83));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(118, 54, 338, 240);
		panel.setBackground(new Color(204, 207, 208));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(79, 70, 46, 14);
		panel.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(79, 92, 186, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(79, 123, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldUsuario.getText() != null && textFieldUsuario.getText().isEmpty() && passwordField.getText() != null && passwordField.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(btnNewButton, "Informações Válidas");
					
				} else {
					
					//Aviso + título do aviso + ícone
					JOptionPane.showMessageDialog(btnNewButton, "Verifique as informações", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		btnNewButton.setBackground(new Color(83, 83, 83));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(130, 192, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Bem Vindo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(130, 21, 102, 14);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(79, 148, 186, 20);
		panel.add(passwordField);
	}
}
