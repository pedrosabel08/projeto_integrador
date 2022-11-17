package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;

import controle.ProdutoBD;
import controle.VendaBD;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;

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
		setTitle("Tela de Vendas");

		TelaVenda tv = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCliente.class.getResource("/Imagens/carrinhodecompras.png")));
		setBounds(100, 100, 1200, 620);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Funcionario:");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 11, 136, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(23, 59, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtIDFunc = new JTextField();
		txtIDFunc.setBackground(Color.WHITE);
		txtIDFunc.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtIDFunc.setEditable(false);
		txtIDFunc.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDFunc.setBounds(56, 56, 46, 20);
		contentPane.add(txtIDFunc);
		txtIDFunc.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 59, 730, 333);
		contentPane.add(scrollPane);
		tbCarrinho = new JTable();
		tbCarrinho.setBackground(UIManager.getColor("Button.light"));
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Cliente","Funcionario", "Preco" });

		tbCarrinho.setModel(model);
		scrollPane.setViewportView(tbCarrinho);

		JButton btnPesquisarFunc = new JButton("Pesquisar");
		btnPesquisarFunc.setBackground(UIManager.getColor("Button.shadow"));
		btnPesquisarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaFuncionario TF = new TabelaFuncionario(tv);
				TF.setVisible(true);
			}
		});
		btnPesquisarFunc.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnPesquisarFunc.setBounds(142, 54, 102, 23);
		contentPane.add(btnPesquisarFunc);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(23, 101, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtNomeFunc = new JTextField();
		txtNomeFunc.setBackground(Color.WHITE);
		txtNomeFunc.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtNomeFunc.setEditable(false);
		txtNomeFunc.setBounds(79, 98, 165, 20);
		contentPane.add(txtNomeFunc);
		txtNomeFunc.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblCliente.setBounds(23, 335, 102, 37);
		contentPane.add(lblCliente);

		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(23, 380, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		txtIDCliente = new JTextField();
		txtIDCliente.setBackground(Color.WHITE);
		txtIDCliente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtIDCliente.setEditable(false);
		txtIDCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDCliente.setColumns(10);
		txtIDCliente.setBounds(56, 377, 46, 20);
		contentPane.add(txtIDCliente);

		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.setBackground(UIManager.getColor("Button.shadow"));
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaClientes tc = new TabelaClientes(tv);
				tc.setVisible(true);
			}
		});
		btnPesquisarCliente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnPesquisarCliente.setBounds(142, 375, 102, 23);
		contentPane.add(btnPesquisarCliente);

		JLabel lblNewLabel_2_1 = new JLabel("Nome:");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setBackground(SystemColor.window);
		lblNewLabel_2_1.setBounds(23, 422, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBackground(Color.WHITE);
		txtNomeCliente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(79, 419, 165, 20);
		contentPane.add(txtNomeCliente);

		JLabel lblProdutos = new JLabel("Produtos:");
		lblProdutos.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblProdutos.setBounds(23, 153, 102, 37);
		contentPane.add(lblProdutos);

		JLabel lblNewLabel_1_2 = new JLabel("ID:");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(23, 205, 46, 14);
		contentPane.add(lblNewLabel_1_2);

		txtIDProd = new JTextField();
		txtIDProd.setBackground(Color.WHITE);
		txtIDProd.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtIDProd.setEditable(false);
		txtIDProd.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDProd.setColumns(10);
		txtIDProd.setBounds(56, 202, 46, 20);
		contentPane.add(txtIDProd);

		JButton btnPesquisarProd = new JButton("Pesquisar");
		btnPesquisarProd.setBackground(UIManager.getColor("Button.shadow"));
		btnPesquisarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaProduto tp = new TabelaProduto(tv);
				tp.setVisible(true);
			}
		});
		btnPesquisarProd.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnPesquisarProd.setBounds(142, 201, 102, 23);
		contentPane.add(btnPesquisarProd);

		JLabel lblNewLabel_2_2 = new JLabel("Nome:");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(23, 247, 46, 14);
		contentPane.add(lblNewLabel_2_2);

		txtNomeProd = new JTextField();
		txtNomeProd.setBackground(Color.WHITE);
		txtNomeProd.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtNomeProd.setEditable(false);
		txtNomeProd.setColumns(10);
		txtNomeProd.setBounds(79, 244, 165, 20);
		contentPane.add(txtNomeProd);

		JLabel lblNewLabel_2_2_1 = new JLabel("Preco (R$):");
		lblNewLabel_2_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(23, 275, 79, 14);
		contentPane.add(lblNewLabel_2_2_1);

		txtPreco = new JTextField();
		txtPreco.setBackground(Color.WHITE);
		txtPreco.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(112, 272, 132, 20);
		contentPane.add(txtPreco);

		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(765, 24, 77, 14);
		contentPane.add(lblNewLabel_3);

		txtQtd = new JTextField();
		txtQtd.setBackground(Color.WHITE);
		txtQtd.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtQtd.setHorizontalAlignment(SwingConstants.CENTER);
		txtQtd.setColumns(10);
		txtQtd.setBounds(852, 21, 46, 20);
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
								model.addRow(new Object[] { produtoSelecionado.getId(), produtoSelecionado.getNome(), clienteSelecionado.getNome(), funcionarioSelecionado.getNome(), produtoSelecionado.getPreco() });

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
					somaTotal += Double.parseDouble(model.getValueAt(i, 4).toString());
				txtTotal.setText(String.valueOf(somaTotal));
			}

		});
		btnAdicionar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnAdicionar.setBackground(UIManager.getColor("Button.shadow"));
		btnAdicionar.setBounds(963, 20, 105, 23);
		contentPane.add(btnAdicionar);

		JLabel lblCarrinhoDeCompras = new JLabel("Carrinho de Compras");
		lblCarrinhoDeCompras.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblCarrinhoDeCompras.setBounds(338, 11, 200, 37);
		contentPane.add(lblCarrinhoDeCompras);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(UIManager.getColor("Button.shadow"));
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBackground(UIManager.getColor("Button.shadow"));
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
		btnSelecionar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
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
		btnExcluir.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnExcluir.setBounds(450, 403, 102, 23);
		contentPane.add(btnExcluir);

		JLabel lblNewLabel_4 = new JLabel("Valor Total:");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(883, 407, 89, 14);
		contentPane.add(lblNewLabel_4);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtTotal.setBounds(982, 403, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);

		JButton btnFinalizar = new JButton("Finalizar (Enter)");
		btnFinalizar.setBackground(UIManager.getColor("Button.shadow"));
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for(int i=0; i < model.getRowCount();i++) {
					String id_cliente = txtIDCliente.getText();
					String id_funcionario = txtIDFunc.getText();
					String id_produto = (tbCarrinho.getValueAt(i, 0).toString());
					String nome_produto = (tbCarrinho.getValueAt(i,1).toString());
					String nome_func = (tbCarrinho.getValueAt(i,2).toString());
					String nome_cliente = (tbCarrinho.getValueAt(i,3).toString());
					String preco = (tbCarrinho.getValueAt(i, 4).toString());
					DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String h =(dtf5.format(LocalDateTime.now()));

					Venda venda = new Venda();

					venda.setCliente(Integer.valueOf(id_cliente));
					venda.setFuncionario(Integer.valueOf(id_funcionario));
					venda.setProduto(Integer.valueOf(id_produto));
					venda.setNome_cliente(nome_cliente);
					venda.setNome_produto(nome_produto);
					venda.setNome_func(nome_func);
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

				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
				
				txtIDFunc.setText("");
				txtIDProd.setText("");
				txtIDCliente.setText("");
				txtNomeFunc.setText("");
				txtNomeCliente.setText("");
				txtNomeProd.setText("");
				txtPreco.setText("");
			}

		});
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
        .addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                if(event.getID() == KeyEvent.KEY_RELEASED 
                   && event.getKeyCode() == KeyEvent.VK_ENTER){
    				for(int i=0; i < model.getRowCount();i++) {
    					String id_cliente = txtIDCliente.getText();
    					String id_funcionario = txtIDFunc.getText();
    					String id_produto = (tbCarrinho.getValueAt(i, 0).toString());
    					String nome_produto = (tbCarrinho.getValueAt(i,1).toString());
    					String nome_func = (tbCarrinho.getValueAt(i,2).toString());
    					String nome_cliente = (tbCarrinho.getValueAt(i,3).toString());
    					String preco = (tbCarrinho.getValueAt(i, 4).toString());
    					DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    					String h =(dtf5.format(LocalDateTime.now()));

    					Venda venda = new Venda();

    					venda.setCliente(Integer.valueOf(id_cliente));
    					venda.setFuncionario(Integer.valueOf(id_funcionario));
    					venda.setProduto(Integer.valueOf(id_produto));
    					venda.setNome_cliente(nome_cliente);
    					venda.setNome_produto(nome_produto);
    					venda.setNome_func(nome_func);
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

    				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                       return true;
                 }
                 return false;
            }
    }); 
		btnFinalizar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btnFinalizar.setBounds(338, 456, 214, 55);
		contentPane.add(btnFinalizar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(UIManager.getColor("Button.shadow"));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial inicio = new TelaInicial();
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);

			}
		});
		btnFechar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnFechar.setBounds(914, 456, 154, 23);
		contentPane.add(btnFechar);

		JButton btnHistorico = new JButton("Historico de Vendas");
		btnHistorico.setBackground(UIManager.getColor("Button.shadow"));
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoVendas HV = new HistoricoVendas(tv);
				HV.setVisible(true);
			}
		});
		btnHistorico.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		btnHistorico.setBounds(914, 490, 154, 23);
		contentPane.add(btnHistorico);

	}	
}
