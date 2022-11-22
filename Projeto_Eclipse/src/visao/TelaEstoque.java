package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ProdutoBD;
import modelo.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTable tabelaProduto;
	private JTextField txtTamanho;
	private JTextField txtCor;
	private JTextField txtID;
	private JTextField txtPreco;
	private JTextField txtQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque frame = new TelaEstoque();
					frame.setLocationRelativeTo(null);
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
	public TelaEstoque() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaEstoque.class.getResource("/Imagens/produtos.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1900, 1000);
		this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel.setBounds(525, 648, 176, 30);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtNome.setBounds(525, 679, 176, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(777, 648, 176, 30);
		contentPane.add(lblNewLabel_1);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtMarca.setBounds(777, 679, 176, 30);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnCadastrar.setBackground(UIManager.getColor("Button.shadow"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProduto();
				listarValores();
				LimparCampos();
		}
		});
		btnCadastrar.setBounds(317, 772, 176, 30);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 147, 1321, 471);
		contentPane.add(scrollPane);
		
		
		
		tabelaProduto = new JTable();
		tabelaProduto.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		tabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Marca", "Tamanho", "Cor", "Preco", "Quantidade"
			}
		));
		tabelaProduto.setBounds(220, 221, 155, -152);
		scrollPane.setViewportView(tabelaProduto);

		try {
			ProdutoBD produtoBD = new ProdutoBD();
			
			DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
			model.setNumRows(0);
			
			ArrayList<Produto> lista = produtoBD.pesquisarProduto();
			
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getMarca(),
						lista.get(num).getTamanho(),
						lista.get(num).getCor(),
						lista.get(num).getPreco(),
						lista.get(num).getQuantidade()
				});
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_1.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCampos();
			}
		});
		btnNewButton_1.setBounds(546, 772, 176, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_2.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_2.setBounds(1234, 772, 176, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_3.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabelaProduto.getSelectedRowCount() > 0) {
				AlterarProduto();
				listarValores();
				LimparCampos();
				}
				else {
				JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela para alterar!");
				}
			}
		});
		btnNewButton_3.setBounds(777, 772, 176, 30);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_4.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabelaProduto.getSelectedRowCount() > 0) {
				excluirProduto();
				listarValores();
				}
				else {
				JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela para excluir!");
				}
			}
		});
		btnNewButton_4.setBounds(1009, 772, 176, 30);
		contentPane.add(btnNewButton_4);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamanho.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblTamanho.setBounds(998, 648, 88, 30);
		contentPane.add(lblTamanho);
		
		txtTamanho = new JTextField();
		txtTamanho.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtTamanho.setColumns(10);
		txtTamanho.setBounds(998, 679, 88, 30);
		contentPane.add(txtTamanho);
		
		JLabel lblNewLabel_2 = new JLabel("Cor:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(1123, 648, 176, 30);
		contentPane.add(lblNewLabel_2);
		
		txtCor = new JTextField();
		txtCor.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtCor.setColumns(10);
		txtCor.setBounds(1123, 679, 176, 30);
		contentPane.add(txtCor);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(367, 679, 74, 30);
		contentPane.add(txtID);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblId.setBounds(367, 646, 74, 30);
		contentPane.add(lblId);
		
		JButton btnNewButton_5 = new JButton("Fechar");
		btnNewButton_5.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);
				
			}
		});
		btnNewButton_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton_5.setBounds(1462, 772, 176, 30);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("Preco");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(1347, 648, 100, 30);
		contentPane.add(lblNewLabel_3);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtPreco.setColumns(10);
		txtPreco.setBounds(1347, 679, 100, 30);
		contentPane.add(txtPreco);
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(1476, 648, 162, 30);
		contentPane.add(lblNewLabel_4);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(1505, 679, 88, 30);
		contentPane.add(txtQuantidade);
		
		JLabel lblNewLabel_5 = new JLabel("Tela de Produtos");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_5.setBounds(317, 50, 1321, 46);
		contentPane.add(lblNewLabel_5);
		
	}
	
	private void SelecionarCampos() {
		if(tabelaProduto.getSelectedRowCount() > 0) {

		int setar = tabelaProduto.getSelectedRow();
		
		txtID.setText(tabelaProduto.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tabelaProduto.getModel().getValueAt(setar, 1).toString());
		txtMarca.setText(tabelaProduto.getModel().getValueAt(setar, 2).toString());
		txtTamanho.setText(tabelaProduto.getModel().getValueAt(setar, 3).toString());
		txtCor.setText(tabelaProduto.getModel().getValueAt(setar, 4).toString());
		txtPreco.setText(tabelaProduto.getModel().getValueAt(setar, 5).toString());
		txtQuantidade.setText(tabelaProduto.getModel().getValueAt(setar, 6).toString());
	}
		else {
			JOptionPane.showMessageDialog(null,"Clique em uma linha da tabela para selecionar!");
		}
	}
	
	private void CadastrarProduto() {
		String nome, marca, tamanho, cor, preco;
		int quantidade;
		
		nome = txtNome.getText();
		marca = txtMarca.getText();
		tamanho = txtTamanho.getText();
		cor = txtCor.getText();
		preco = txtPreco.getText();
		quantidade = Integer.parseInt(txtQuantidade.getText());
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setMarca(marca);
		produto.setTamanho(tamanho);
		produto.setCor(cor);
		produto.setPreco(Double.valueOf(preco));
		produto.setQuantidade(quantidade);
		
		ProdutoBD produtoBD = new ProdutoBD();
		produtoBD.cadastrarProduto(produto);
	}
	private void LimparCampos() {
		txtID.setText("");
		txtNome.setText("");
		txtMarca.setText("");
		txtTamanho.setText("");
		txtCor.setText("");
		txtPreco.setText("");
		txtQuantidade.setText("");
		txtNome.requestFocus();
	}
	private void AlterarProduto() {
		int id, quantidade;
		String nome, marca, tamanho, cor, preco;
		
		id = Integer.parseInt(txtID.getText());
		nome = txtNome.getText();
		marca = txtMarca.getText();
		tamanho = txtTamanho.getText();
		cor = txtCor.getText();
		preco = txtPreco.getText();
		quantidade = Integer.parseInt(txtQuantidade.getText());
		
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setMarca(marca);
		produto.setTamanho(tamanho);
		produto.setCor(cor);
		produto.setPreco(Double.valueOf(preco));
		produto.setQuantidade(quantidade);
		
		ProdutoBD produtoBD = new ProdutoBD();
		produtoBD.alterarProduto(produto);
	}
	private void excluirProduto() {
		int id;
		
		id = Integer.parseInt(txtID.getText());
		
		Produto produto = new Produto();
		produto.setId(id);
		
		ProdutoBD produtoBD = new ProdutoBD();
		produtoBD.excluirProduto(produto);
	}
	private void listarValores() {
		try {
			ProdutoBD produtoBD = new ProdutoBD();
			
			DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
			model.setNumRows(0);
			
			ArrayList<Produto> lista = produtoBD.pesquisarProduto();
			
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getMarca(),
						lista.get(num).getTamanho(),
						lista.get(num).getCor(),
						lista.get(num).getPreco(),
						lista.get(num).getQuantidade()
				});
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
	}
}
