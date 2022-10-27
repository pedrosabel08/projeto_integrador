package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ProdutoBD;
import controle.VendaBD;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;

public class TelaVenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	private Produto produtoSelecionado;
	private Funcionario funcionarioSelecionado;
	private Cliente clienteSelecionado;

	public JTable tbCarrinho;

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

	public void setFuncionarioSelecionado(Funcionario funcionario) {
		this.funcionarioSelecionado = funcionario;
		this.txtIDFunc.setText(String.valueOf(funcionario.getId()));
		this.txtNomeFunc.setText(funcionario.getNome());
	}

	public void setClienteSelecionado(Cliente cliente) {
		this.clienteSelecionado = cliente;
		this.txtIDCliente.setText(String.valueOf(cliente.getId()));
		this.txtNomeCliente.setText(cliente.getNome());
	}

	public void setProdutoSelecionado(Produto produto) {
		this.produtoSelecionado = produto;
		this.txtIDProd.setText(String.valueOf(produto.getId()));
		this.txtNomeProd.setText(produto.getNome());
		this.txtPreco.setText(String.valueOf(produto.getPreco()));
	}
	ProdutoBD produtoBD = new ProdutoBD();

	/**
	 * Create the frame.
	 */
	String teste;
	public TelaVenda() {

		TelaVenda tv = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Funcionario:");
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
		txtIDCliente.setEditable(false);
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
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Preco" });
		tbCarrinho.setModel(model);
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

		JLabel lblNewLabel_2_2_1 = new JLabel("Preco (R$):");
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

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtoBD = new ProdutoBD();
				Produto Cp1 = new Produto();
				String id= txtIDProd.getText();
				
				Cp1.setId(Integer.valueOf(id));
				Cp1 = produtoBD.listarqtdID(Cp1);
				
				int quantidade1 = Cp1.getQuantidade();
				String quantidadeVendido = txtQtd.getText();
				int quantidadeVendida = Integer.valueOf(quantidadeVendido);
				int total =quantidade1 - quantidadeVendida;
				if(quantidade1 >= quantidadeVendida) {	
				String qtdProdutos = txtQtd.getText();
				if (qtdProdutos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma quantidade inserida!");

				} else {

					Integer qtd = Integer.valueOf(qtdProdutos);

					if (produtoSelecionado != null) {
						for (int i = 0; i < qtd; i++) {
							model.addRow(new Object[] { produtoSelecionado.getId(), produtoSelecionado.getNome(),
									produtoSelecionado.getPreco() });

						}

						tbCarrinho.setModel(model);
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!");
					}
				}
				Cp1.setQuantidade(total);
				Cp1.setId(Integer.valueOf(id));
				Cp1 = produtoBD.diminuirEstoque(Cp1);
				
			
		}else
			if(quantidadeVendida > quantidade1) {
				JOptionPane.showMessageDialog(null, "estoque insuficiente");
			}
			double somaTotal=0;
			
		    for(int i=0; i<model.getRowCount();i++)
		        somaTotal += Double.parseDouble(model.getValueAt(i, 2).toString());
		    txtTotal.setText(String.valueOf(somaTotal));
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
		
		JButton btnExcluir = new JButton("Excluir");
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoPessoa = tbCarrinho.getSelectedRow();
				
				 if(posicaoPessoa > -1) {
					btnExcluir.setEnabled(true);
					 teste = tbCarrinho.getValueAt(tbCarrinho.getSelectedRow(), 0).toString();
						
				}else {
					JOptionPane.showMessageDialog(null,"escolha uma linha na tabela");
					}
			}
		});
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSelecionar.setBounds(338, 403, 102, 23);
		contentPane.add(btnSelecionar);

		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
((DefaultTableModel) tbCarrinho.getModel()).removeRow(tbCarrinho.getSelectedRow());
			
				
				Produto Cp1 = new Produto();
				String id= (teste);
				
				Cp1.setId(Integer.valueOf(id));
				Cp1 = produtoBD.listarProdutosID(Cp1);
				int total = Cp1.getQuantidade() + 1;
				
				 Cp1.setQuantidade(total);
				 Cp1.setId(Integer.valueOf(id));
				 Cp1 = produtoBD.diminuirEstoque(Cp1);
				
				double somaTotal=0;
			    for(int i=0; i<model.getRowCount();i++)
			        somaTotal += Double.parseDouble(model.getValueAt(i, 2).toString());
			    lblNewLabel_1.setText(String.valueOf(somaTotal));
			    btnExcluir.setEnabled(false);
			}
		});
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

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 for(int i=0; i<model.getRowCount();i++) { 
					 String id_cadastro = txtIDCliente.getText();
						String id_usuario = txtIDFunc.getText();
						String id_produto = (tbCarrinho.getValueAt(tbCarrinho.getAutoResizeMode(), 0).toString());
						String preco = (tbCarrinho.getValueAt(tbCarrinho.getAutoResizeMode(), 2).toString());
						DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				        String h =(dtf5.format(LocalDateTime.now()));
				  
						Venda venda = new Venda();
						
						    venda.setCadastro(Integer.valueOf(id_cadastro));
						    venda.setUsuario(Integer.valueOf(id_usuario));
						    venda.setProduto(Integer.valueOf(id_produto));
						    venda.setValor(Double.valueOf(preco));
						    venda.setData(h);
						
						VendaBD bdVenda = new VendaBD();
						bdVenda.inserirVenda(venda);

				  }
				  while(tbCarrinho.getModel().getRowCount()>0){
						 ((DefaultTableModel) tbCarrinho.getModel()).removeRow(0);
					}
				    txtTotal.setText("");
				    txtQtd.setText("");
			}
		});
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFinalizar.setBounds(338, 456, 102, 23);
		contentPane.add(btnFinalizar);

	}
}