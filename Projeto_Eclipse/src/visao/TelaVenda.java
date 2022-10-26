package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controle.FuncionarioBD;
import controle.ClienteBD;
import controle.ProdutoBD;
import modelo.Funcionario;
import modelo.Cliente;
import modelo.Produto;


public class TelaVenda extends JFrame {

	public JPanel contentPane;
	public JTextField txtIDFunc;
	public JTextField txtNomeFunc;
	public JTextField txtIDCliente;
	public JTextField txtNomeCliente;
	public JTextField txtIDProd;
	public JTextField txtNomeProd;
	public JTextField txtPreco;
	public JTextField txtQtd;
	public JTextField txtTotal;
	
	private DefaultTableModel model;
	
	ProdutoBD produtoBD = new ProdutoBD();
	FuncionarioBD funcionarioBD = new FuncionarioBD();
	ClienteBD clienteBD = new ClienteBD();
	
	Produto p1 = new Produto();
	Funcionario f = new Funcionario();
	Cliente c = new Cliente();
	private JTable tbCarrinho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaVenda() {
		
		TelaVenda tv = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Funcionário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 102, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(10, 59, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtIDFunc = new JTextField();
		txtIDFunc.setEditable(false);
		txtIDFunc.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDFunc.setBounds(43, 56, 46, 20);
		contentPane.add(txtIDFunc);
		txtIDFunc.setColumns(10);
		
		JButton btnPesquisarFunc = new JButton("Pesquisar");
		btnPesquisarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaFuncionario TF = new TabelaFuncionario(tv);
				TF.setVisible(true);
			}
		});
		btnPesquisarFunc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisarFunc.setBounds(161, 54, 89, 23);
		contentPane.add(btnPesquisarFunc);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(10, 101, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setEditable(false);
		txtNomeFunc.setBounds(52, 98, 166, 20);
		contentPane.add(txtNomeFunc);
		txtNomeFunc.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCliente.setBounds(492, 11, 102, 37);
		contentPane.add(lblCliente);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setBounds(492, 56, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtIDCliente = new JTextField();
		txtIDCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDCliente.setColumns(10);
		txtIDCliente.setBounds(525, 53, 46, 20);
		contentPane.add(txtIDCliente);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TabelaClientes tc = new TabelaClientes(tv);
			tc.setVisible(true);
			}
		});
		btnPesquisarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisarCliente.setBounds(654, 54, 89, 23);
		contentPane.add(btnPesquisarCliente);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome:");
		lblNewLabel_2_1.setBounds(492, 98, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 272, 500, 120);
		contentPane.add(scrollPane);
		
		tbCarrinho = new JTable();
		tbCarrinho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "preço"
			}
		));
		scrollPane.setViewportView(tbCarrinho);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(534, 95, 166, 20);
		contentPane.add(txtNomeCliente);
		
		JLabel lblProdutos = new JLabel("Produtos:");
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProdutos.setBounds(10, 220, 102, 37);
		contentPane.add(lblProdutos);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID:");
		lblNewLabel_1_2.setBounds(10, 272, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtIDProd = new JTextField();
		txtIDProd.setEditable(false);
		txtIDProd.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDProd.setColumns(10);
		txtIDProd.setBounds(43, 269, 46, 20);
		contentPane.add(txtIDProd);
		
		JButton btnPesquisarProd = new JButton("Pesquisar");
		btnPesquisarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaProduto tp = new TabelaProduto(tv);
				tp.setVisible(true);
			}
		});
		btnPesquisarProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisarProd.setBounds(129, 268, 89, 23);
		contentPane.add(btnPesquisarProd);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nome:");
		lblNewLabel_2_2.setBounds(10, 314, 46, 14);
		contentPane.add(lblNewLabel_2_2);
		
		txtNomeProd = new JTextField();
		txtNomeProd.setEditable(false);
		txtNomeProd.setColumns(10);
		txtNomeProd.setBounds(52, 311, 166, 20);
		contentPane.add(txtNomeProd);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Preço (R$):");
		lblNewLabel_2_2_1.setBounds(10, 342, 79, 14);
		contentPane.add(lblNewLabel_2_2_1);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(82, 339, 136, 20);
		contentPane.add(txtPreco);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setBounds(534, 233, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		txtQtd = new JTextField();
		txtQtd.setHorizontalAlignment(SwingConstants.CENTER);
		txtQtd.setColumns(10);
		txtQtd.setBounds(615, 230, 46, 20);
		contentPane.add(txtQtd);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 produtoBD = new ProdutoBD();
				 p1 = new Produto();
				String ID= txtIDProd.getText();
				
				p1.setId(Integer.valueOf(ID));
				p1 = produtoBD.listarProdutosID(p1);
				 
					String nome = p1.getNome();
					String preco = p1.getPreco();
					txtNomeProd.setText(nome);
					txtPreco.setText(String.valueOf(preco));
			    
			}
		});
		btnNewButton.setBounds(581, 52, 43, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				produtoBD = new ProdutoBD();
				Produto p = new Produto();
				String id= txtIDProd.getText();
				
				p.setId(Integer.valueOf(id));
				p = produtoBD.listarqtdID(p);
				
				int qtd = p.getQuantidade();
				String qtdVendido = txtQtd.getText();
				int qtdVendida = Integer.valueOf(qtdVendido);
				int total = qtd - qtdVendida;
				if(qtd > qtdVendida) {	
				
				if (!txtQtd.getText().isEmpty()) {
					model = (DefaultTableModel) tbCarrinho.getModel();
					
					Integer qtdProdutos = Integer.valueOf(txtQtd.getText());
					txtIDProd.setText("");
					txtNomeProd.setText("");
					txtPreco.setText("");
					 
					for (int i = 0; i < qtdProdutos; i++) {

						model.addRow(new Object[] { p.getId(), p.getNome(), p.getPreco() });
					}
					btnAdicionar.setEnabled(false);
					
					
					
					p.setQuantidade(total);
					p.setId(Integer.valueOf(id));
					p = produtoBD.diminuirEstoque(p);
					
				}
			}else
				if(qtdVendida > qtd) {
					JOptionPane.showMessageDialog(null, "não existe no estoque");
				}
				double somaTotal=0;
				
			    for(int i=0; i<model.getRowCount();i++)
			        somaTotal += Double.parseDouble(model.getValueAt(i, 2).toString());
			    txtTotal.setText(String.valueOf(somaTotal));
			    
			    txtQtd.setText("");
				
			}
			
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdicionar.setBackground(new Color(240, 240, 240));
		btnAdicionar.setBounds(733, 230, 105, 23);
		contentPane.add(btnAdicionar);
		
		
		
		
		
		
		
		JLabel lblCarrinhoDeCompras = new JLabel("Carrinho de Compras");
		lblCarrinhoDeCompras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCarrinhoDeCompras.setBounds(338, 220, 200, 37);
		contentPane.add(lblCarrinhoDeCompras);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSelecionar.setBounds(338, 403, 102, 23);
		contentPane.add(btnSelecionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.setBounds(450, 403, 102, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_4 = new JLabel("Valor Total:");
		lblNewLabel_4.setBounds(615, 408, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(680, 405, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		
	}
}