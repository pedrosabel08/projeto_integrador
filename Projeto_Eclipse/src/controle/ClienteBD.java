package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Funcionario;

public class ClienteBD {
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Cliente> lista = new ArrayList<>();
	
	public void cadastrarCliente(Cliente cliente) {
		String sql = "insert into clientes (nome,cpf,rg,data_nascimento) values (?,?,?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCPF());
			stmt.setString(3, cliente.getRG());
			stmt.setString(4, cliente.getData_nascimento());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os campos para cadastrar!");
		}
		
	}
	public ArrayList <Cliente> pesquisarCliente(){
		String sql = "select * from clientes";
		
		conn = new Conexao().faz_conexao();
		
		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idClientes"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setRG(rs.getString("rg"));
				cliente.setData_nascimento(rs.getString("data_nascimento"));
				
				lista.add(cliente);
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar -> " + e);
		}
		return lista;
	}
	
	public void alterarCliente(Cliente cliente) {
		String sql = "update clientes set nome = ?, cpf = ?, rg = ?, data_nascimento = ? where idClientes = ?";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCPF());
			stmt.setString(3, cliente.getRG());
			stmt.setString(4, cliente.getData_nascimento());
			stmt.setInt(5, cliente.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao alterar -> " + e);
		}
	}
	public void excluirCliente(Cliente cliente) {
		String sql = "delete from clientes where idClientes = ?";

		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao excluir -> " + e);
		}
	}

}
