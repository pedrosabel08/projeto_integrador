package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Venda;


public class VendaBD {
	static Connection conn;
	ArrayList<Venda> listarVenda = new ArrayList<>();
	
	public VendaBD() {
		conn = new Conexao().faz_conexao();
	}
	
	public ArrayList<Venda> buscarVenda() {

		PreparedStatement ps;
	    ResultSet rs;
	    
		try {
			ps = conn.prepareStatement ("select idVenda, p.nome, c.nome, f.nome, valor, data from venda v inner join produtos p on v.idProdutos = p.idProdutos inner join clientes c on v.idClientes = c.idClientes inner join funcionario f on v.idFuncionario = f.idFuncionario;");
			rs = ps.executeQuery();
			while( rs.next() ){
				Venda venda = new Venda();
			    venda.setId(rs.getInt("idVenda"));
			    venda.setNome_produto(rs.getString("p.nome"));
			    venda.setNome_cliente(rs.getString("c.nome"));
			    venda.setNome_func(rs.getString("f.nome"));
			    venda.setValor(rs.getDouble("valor"));
			    venda.setData(rs.getString("data"));
		    	
			    listarVenda.add(venda);
	     }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    return listarVenda;
	}
	
	public int inserirVenda(Venda v) {
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement("insert into venda (idProdutos, idClientes, idFuncionario, valor , data) values(?,?,?,?,?)");
			ps.setInt(1, v.getProduto());
			ps.setInt(2, v.getCliente());
			ps.setInt(3, v.getFuncionario());
			ps.setDouble(4,v.getValor());
			ps.setString(5,v.getData());
			
			ps.executeUpdate();
		
			
			}catch(SQLException e1) {
				
				e1.printStackTrace();
			}
	return 0;
}
}