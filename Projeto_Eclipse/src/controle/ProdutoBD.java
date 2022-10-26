package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Produto;
import modelo.Produto;

public class ProdutoBD {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Produto> lista = new ArrayList<>();
	
	public void cadastrarProduto(Produto produto) {
		String sql = "insert into produtos (nome, marca, tamanho, cor, preco, quantidade) values (?, ?, ?, ?, ?, ?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getTamanho());
			stmt.setString(4, produto.getCor());
			stmt.setString(5, produto.getPreco());
			stmt.setInt(6, produto.getQuantidade());
			
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!" + e);
		}
		
	}
	public ArrayList <Produto> pesquisarProduto(){
		String sql = "select * from produtos";
		
		conn = new Conexao().faz_conexao();
		
		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("idProdutos"));
				produto.setNome(rs.getString("nome"));
				produto.setMarca(rs.getString("marca"));
				produto.setTamanho(rs.getString("tamanho"));
				produto.setCor(rs.getString("cor"));
				produto.setPreco(rs.getString("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				
				lista.add(produto);
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar -> " + e);
		}
		return lista;
	}
	
	public void alterarProduto(Produto produto) {
		String sql = "update produtos set nome = ?, marca = ?, tamanho = ?, cor = ?, preco = ?, quantidade = ? where idProdutos = ?";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getTamanho());
			stmt.setString(4, produto.getCor());
			stmt.setString(5, produto.getPreco());
			stmt.setInt(6, produto.getQuantidade());
			stmt.setInt(7, produto.getId());
			
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Produto alterado com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao alterar -> " + e);
		}
	}
	public void excluirProduto(Produto produto) {
		String sql = "delete from produtos where idProdutos = ?";

		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, produto.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Produto excluido com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao excluir -> " + e);
		}
	}
	public Produto listarqtdID(Produto produto) {
		PreparedStatement ps;
		ResultSet rs;
		Produto quantidadeID = null;
		try {
			ps = conn.prepareStatement("select quantidade from produtos where idProdutos = ? ");
			ps.setInt(1, produto.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				quantidadeID = new Produto();
				
				quantidadeID.setQuantidade(rs.getInt("quantidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidadeID;
	}
	public Produto diminuirEstoque(Produto produto) {

		try {


			PreparedStatement ps = conn.prepareStatement("update produtos set quantidade=? where idProdutos = ?");
			ps.setInt(1, produto.getQuantidade());
			ps.setInt(2, produto.getId());
			ps.executeUpdate();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return null;
	}
	
	public Produto listarProdutosID(Produto produto) {
		PreparedStatement ps;
		ResultSet rs;
		Produto prod = null;
		try {
			ps = conn.prepareStatement("select * from produtos where  idProduto = ? ");
			ps.setInt(1, produto.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				prod = new Produto();
				prod.setId(rs.getInt("idProdutos"));
				prod.setCor(rs.getString("cor"));
				prod.setTamanho(rs.getString("tamanho"));
				prod.setMarca(rs.getString("marca"));
				prod.setPreco(rs.getString("preco"));
				prod.setQuantidade(rs.getInt("quantidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
	}
}
