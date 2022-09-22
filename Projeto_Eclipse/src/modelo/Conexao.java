package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	static Connection conn;
	static Statement st;

	public Conexao() {
	}

	public static Connection faz_conexao() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_senhas", "root", "aluno");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

		}
		return conn;

	}

	public void desconectar() {
		try {
			conn.close();
		} catch (Exception e) {

		}
	}
}
