package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UsuarioCONTROLLER;
import model.UsuarioMODEL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import model.UsuarioMODEL;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JTextField txtSenhaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nome completo");
		lblNewLabel.setBounds(31, 32, 108, 15);
		contentPane.add(lblNewLabel);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtNomeUsuario.setBounds(31, 59, 334, 19);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("senha");
		lblNewLabel_1.setBounds(31, 104, 70, 28);
		contentPane.add(lblNewLabel_1);
		
		txtSenhaUsuario = new JTextField();
		txtSenhaUsuario.setBounds(31, 132, 334, 19);
		contentPane.add(txtSenhaUsuario);
		txtSenhaUsuario.setColumns(10);
		
		JButton btnEnviar = new JButton("enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logar();
				
			}
		});
		btnEnviar.setBounds(31, 210, 117, 25);
		contentPane.add(btnEnviar);
	}
	
	private void logar() {
		try {
			
			String nome_usuario , senha_usuario;
			
			nome_usuario = txtNomeUsuario.getText();
			senha_usuario = txtSenhaUsuario.getText();
			
			UsuarioMODEL objusuariomodel = new UsuarioMODEL();
			objusuariomodel.setNome_usario(nome_usuario);
			objusuariomodel.setSenha_usuario(senha_usuario);
			
			UsuarioCONTROLLER objusuariocontroller = new UsuarioCONTROLLER();
			ResultSet rsusuariocontroller = objusuariocontroller.autenticacaoUsuario(objusuariomodel);
			
			if (rsusuariocontroller.next()) {
				//chamar tela que eu quero abrir
				FrmPrincipalVIEW frmprincipalview = new FrmPrincipalVIEW();
				frmprincipalview.setVisible(true);
				
				dispose();
			} else {
				//enviar mensagem dizendo incorreto
				JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos");

			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "LoginView" + erro);
		}

	}
}
