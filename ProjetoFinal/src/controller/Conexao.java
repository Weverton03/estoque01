package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	public static Connection conectBD() {
		Connection con = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/projeto_teste?user=wellington&password=590712";
			con = DriverManager.getConnection(url);
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage());
		}
		
		return con;
		
	}
	public static void main(String[] args) {
		//Conexao.conectBD();
		System.out.println(Conexao.conectBD());
	}
}
	

		