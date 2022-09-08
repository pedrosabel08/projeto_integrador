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

	public static Connection faz_conexao() throws SQLException {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db_senhas", "root", "aluno");
			st = conn.createStatement();

		} catch (ClassNotFoundException e) {

			throw new SQLException(e.getException());
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
