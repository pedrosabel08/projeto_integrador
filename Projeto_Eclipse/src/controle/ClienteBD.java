package controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import visao.Cad_Cliente;

public class ClienteBD {
	static Connection conexao;

	public ClienteBD() {	
		try {
			 conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_senhas", "root", "aluno");

		} catch (SQLException e) {
			System.out.println("Erro ao conectar a base de dados.");
		}
	}
	
	

	public int removeCliente(Cliente cliente) {
		try {

			PreparedStatement ps = conexao.prepareStatement("delete from Clientes where id=?");
			ps.setString(1, cliente.getId());
			return ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Erro ao conectar ï¿½ base de dados.");
		}
		return 0;
	}
	
	
	
	
	
	

	public ArrayList<Cliente> listarTodosClientes() {
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			ps = conexao.prepareStatement ("select * from Clientes order by nome");
			rs= ps.executeQuery();
			while(rs.next( ) ) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getString("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setRG(rs.getString("rg"));
				cliente.setData_nascimento(rs.getString("data_nascimento"));
				listaClientes.add(cliente);
		}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return listaClientes;
	}
	
	
	
	
	

	public boolean inserirCliente(Cliente cliente) {

		try {

			PreparedStatement ps = conexao.prepareStatement(
					"insert into clientes (nome,cpf,rg,data_nascimento) values(?,?,?,?)");

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCPF());
			ps.setString(3, cliente.getRG());
			ps.setString(4, cliente.getData_nascimento());
			ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Erro .");
		}

		return false;
	}
}
