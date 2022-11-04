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
			ps = conn.prepareStatement ("select * from venda");
			rs = ps.executeQuery();
			while( rs.next() ){
				Venda venda = new Venda();
			    venda.setId(rs.getInt("idVenda"));
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
			
			ps = conn.prepareStatement("insert into venda (valor , data) values(?,?)");
			ps.setDouble(1,v.getValor());
			ps.setString(2,v.getData());
			
			ps.executeUpdate();
		
			
			}catch(SQLException e1)
			{
				System.out.println("Erro ao conectar ï¿½ base de dados.");
			}
	return 0;
}
}