
import java.sql.*;

public class Conexao {

	
	public static Connection faz_conexao() throws SQLException {
	
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/db_senhas","root", "aluno");
			
			
			
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
			
			
			
		}
	}
}
