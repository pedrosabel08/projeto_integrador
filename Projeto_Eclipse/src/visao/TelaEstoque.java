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

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTable tabelaProduto;
	private JTextField txtTamanho;
	private JTextField txtCor;
	private JTextField txtID;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(47, 132, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(47, 157, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(47, 188, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(47, 213, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProduto();
				listarValores();
				LimparCampos();
		}
		});
		btnCadastrar.setBounds(129, 372, 100, 23);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 57, 464, 288);
		contentPane.add(scrollPane);
		
		tabelaProduto = new JTable();
		tabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Marca", "Tamanho", "Cor"
			}
		));
		tabelaProduto.setBounds(220, 221, 155, -152);
		scrollPane.setViewportView(tabelaProduto);
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnNewButton.setBounds(19, 372, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCampos();
			}
		});
		btnNewButton_1.setBounds(239, 372, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnNewButton_2.setBounds(553, 372, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Alterar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarProduto();
				listarValores();
				LimparCampos();
			}
		});
		btnNewButton_3.setBounds(355, 372, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnNewButton_4.setBounds(454, 372, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(47, 244, 63, 14);
		contentPane.add(lblTamanho);
		
		txtTamanho = new JTextField();
		txtTamanho.setColumns(10);
		txtTamanho.setBounds(47, 269, 86, 20);
		contentPane.add(txtTamanho);
		
		JLabel lblNewLabel_2 = new JLabel("Cor:");
		lblNewLabel_2.setBounds(47, 300, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(47, 325, 86, 20);
		contentPane.add(txtCor);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(47, 101, 86, 20);
		contentPane.add(txtID);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(47, 76, 46, 14);
		contentPane.add(lblId);
		
		JButton btnNewButton_5 = new JButton("Fechar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicial inicio = new TelaInicial();
				inicio.setLocationRelativeTo(null);
				inicio.setVisible(true);
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_5.setBounds(565, 23, 77, 23);
		contentPane.add(btnNewButton_5);
		
	}
	
	private void SelecionarCampos() {
		int setar = tabelaProduto.getSelectedRow();
		
		txtID.setText(tabelaProduto.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tabelaProduto.getModel().getValueAt(setar, 1).toString());
		txtMarca.setText(tabelaProduto.getModel().getValueAt(setar, 2).toString());
		txtTamanho.setText(tabelaProduto.getModel().getValueAt(setar, 3).toString());
		txtCor.setText(tabelaProduto.getModel().getValueAt(setar, 4).toString());
	}
	
	private void CadastrarProduto() {
		String nome, marca, tamanho, cor;
		
		nome = txtNome.getText();
		marca = txtMarca.getText();
		tamanho = txtTamanho.getText();
		cor = txtCor.getText();
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setMarca(marca);
		produto.setTamanho(tamanho);
		produto.setCor(cor);
		
		ProdutoBD produtoBD = new ProdutoBD();
		produtoBD.cadastrarProduto(produto);
	}
	private void LimparCampos() {
		txtID.setText("");
		txtNome.setText("");
		txtMarca.setText("");
		txtTamanho.setText("");
		txtCor.setText("");
		txtNome.requestFocus();
	}
	private void AlterarProduto() {
		int id;
		String nome, marca, tamanho, cor;
		
		id = Integer.parseInt(txtID.getText());
		nome = txtNome.getText();
		marca = txtMarca.getText();
		tamanho = txtTamanho.getText();
		cor = txtCor.getText();
		
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setMarca(marca);
		produto.setTamanho(tamanho);
		produto.setCor(cor);
		
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
						lista.get(num).getCor()
				});
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
	}
}
