package controle;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Cliente;

public class ClienteBD {
	
	private static Statement st;

	public ClienteBD(Connection conexao) {

	}

	public boolean salvar(Cliente cliente) {
		try {
			String sql;
			sql = "INSERT INTO Clientes VALUES('" + cliente.getId() + "','" + cliente.getNome() + "','"
					+ cliente.getCPF() + "','" + cliente.getRG() + "','" + cliente.getData_nascimento() + "','"
					+ cliente.getVenda_idVenda();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
