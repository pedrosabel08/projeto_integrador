package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import visao.TelaEstoque;
import modelo.Produto;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoBD;
import visao.TelaVenda;

public class TabelaProduto extends JFrame {
	
	static Connection conexao;
	private JPanel contentPane;
	private JTable tbProduto;
	private ArrayList<Produto> pesquisarProduto;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabelaProduto(TelaVenda TV ){

		
			System.out.println(conexao);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tbProduto = new JTable();
		tbProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Nome", "Marca", "Tamanho", "Cor", "Preço", "Quantidade"
			}
			
		));
		scrollPane.setViewportView(tbProduto);
		ProdutoBD produtoBD = new ProdutoBD();
		pesquisarProduto = produtoBD.pesquisarProduto();
		
		tbProduto.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {"ID", "Nome", "Marca", "Tamanho", "Cor", "Preço", "Quantidade"}));
		scrollPane.setViewportView(tbProduto);

		modelo = (DefaultTableModel) tbProduto.getModel();
		for (int i = 0; i < pesquisarProduto.size(); i++) {
			Produto p = pesquisarProduto.get(i);
		modelo.addRow(new Object[] { p.getId(), p.getNome(),  p.getMarca(), p.getTamanho(), p.getCor(), p.getPreco(), p.getQuantidade() });

		}
		tbProduto.setModel(modelo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int posicaoPessoa = tbProduto.getSelectedRow();
				
				if(posicaoPessoa > -1) {
					
					
					TV.txtID.setText(tbProduto.getValueAt(tbProduto.getSelectedRow(), 0).toString());
					TV.setVisible(true);
					setVisible(false);				
					}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
			
		});
		panel_1.add(btnNewButton);
	}

}
