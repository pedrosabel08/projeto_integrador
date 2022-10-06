package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Funcionario;

public class FuncionarioBD {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Funcionario> lista = new ArrayList<>();
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		String sql = "insert into funcionario (senha,nome) values (?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!" + e);
		}
		
	}
	public ArrayList <Funcionario> pesquisarFuncionario(){
		String sql = "select * from funcionario";
		
		conn = new Conexao().faz_conexao();
		
		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("idFuncionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSenha(rs.getString("senha"));
				
				lista.add(funcionario);
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar -> " + e);
		}
		return lista;
	}
	
	public void alterarFuncionario(Funcionario funcionario) {
		String sql = "update funcionario set nome = ?, senha = ? where idFuncionario = ?";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			stmt.setInt(3, funcionario.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Funcionario alterado com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao alterar -> " + e);
		}
	}
	public void excluirFuncionario(Funcionario funcionario) {
		String sql = "delete from funcionario where idFuncionario = ?";

		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Funcionario exclu�do com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao excluir -> " + e);
		}
	}
}
