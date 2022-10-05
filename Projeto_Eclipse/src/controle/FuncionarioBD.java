package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import modelo.Funcionario;

public class FuncionarioBD {

	Connection conn;
	PreparedStatement stmt;
	
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
}
