package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UsuarioCONTROLLER;
import model.UsuarioMODEL;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UsuarioView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField psSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioView frame = new UsuarioView();
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
	public UsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(50, 28, 70, 15);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(50, 55, 114, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(50, 86, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(50, 106, 114, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(50, 137, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}

			private void cadastrar() {
				// TODO Auto-generated method stub
				String nome, email, senha;
				
				nome = txtNome.getText();
				email = txtEmail.getText();
				senha = String.valueOf(psSenha.getPassword());
				
				UsuarioMODEL objusuariomodel = new UsuarioMODEL();
				objusuariomodel.setNome_usario(nome);
				objusuariomodel.setSenha_usuario(senha);
				objusuariomodel.setEmail_usuario(email);
				
				UsuarioCONTROLLER objusuariocontroller = new UsuarioCONTROLLER();
				objusuariocontroller.cadastrar(objusuariomodel);
				
				
			}
		});
		btnCadastrar.setBounds(47, 208, 135, 25);
		contentPane.add(btnCadastrar);
		
		psSenha = new JPasswordField();
		psSenha.setBounds(50, 164, 104, 19);
		contentPane.add(psSenha);
	}
}
