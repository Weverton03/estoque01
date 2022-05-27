package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.UsuarioMODEL;

public class UsuarioCONTROLLER {
	Connection conn;
	PreparedStatement pstm;
	
	
	public void cadastrar(UsuarioMODEL objusuariomodel) {
		String sql = "insert into usuari (nome_usuario, email_usuario, senha_usuario) values (?,?,?)";
		
		conn = new Conexao().conectBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariomodel.getNome_usario());
			pstm.setString(2, objusuariomodel.getEmail_usuario());
			pstm.setString(3, objusuariomodel.getSenha_usuario());
			
			pstm.execute();
			pstm.close();
		} catch (Exception erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "UsuarioCONTROLLER" + erro);
		}
		
	}
	
	public ResultSet autenticacaoUsuario(UsuarioMODEL objusuariomodel) {
		conn = new Conexao().conectBD();
		
		try {
			String sql = "select * from usuari where nome_usuario = ? and senha_usuario = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariomodel.getNome_usario());
			pstm.setString(2, objusuariomodel.getSenha_usuario());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "UsuarioCONTROLLER: " + erro);
		}
		return null;
	}

}
