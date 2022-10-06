package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteBD {
	static Connection conexao;

	private static Statement st;

	public ClienteBD() {
		conexao = Conexao.faz_conexao();
	}

	public boolean inserirCliente(Cliente cliente) {

		try {

			PreparedStatement ps = conexao.prepareStatement("insert into clientes (nome,cpf,rg,data_nascimento) values(?,?,?,?)");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCPF());
			ps.setString(3, cliente.getRG());
			ps.setString(4, cliente.getData_nascimento());
			ps.executeUpdate();
			return true;

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

		return false;

	}

	public int alterarClientes(Cliente cliente) {
		try {

			PreparedStatement ps = conexao.prepareStatement("update Clientes set nome=? where id = ?");
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

			ps.executeUpdate();
			ps = conexao.prepareStatement("update Clientes set cpf=? where id = ?");
			ps.setString(1, cliente.getCPF());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

			ps = conexao.prepareStatement("update Clientes set rg=? where id = ?");
			ps.setString(1, cliente.getRG());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

			ps = conexao.prepareStatement("update Clientes set data_nascimento=? where id = ?");
			ps.setString(1, cliente.getData_nascimento());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Cliente> listarClientes() {
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			ps = conexao.prepareStatement("select * from Clientes order by nome");
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setRG(rs.getString("RG"));
				cliente.setData_nascimento(rs.getString("data_nascimento"));
				listaClientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;
	}

	public int removeCliente(Cliente cliente) {
		try {

			PreparedStatement ps = conexao.prepareStatement("delete from Clientes where id=?");
			ps.setInt(1, cliente.getId());
			return ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Erro ao conectar com base de dados.");
		}
		return 0;

	}

}
