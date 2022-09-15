package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Cad_Produto extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtMarca;
	private JTextField txtTamanho;
	private JTextField txtCor;
	private JTextField txtNome;
	private JTextField txtPreco;
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cad_Produto frame = new Cad_Produto();
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
	public Cad_Produto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(85, 28, 46, 14);
		contentPane.add(lblId);

		txtID = new JTextField();
		txtID.setBounds(192, 27, 118, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(85, 84, 46, 14);
		contentPane.add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(192, 83, 118, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTamanho.setBounds(85, 109, 71, 14);
		contentPane.add(lblTamanho);

		txtTamanho = new JTextField();
		txtTamanho.setBounds(192, 108, 118, 20);
		contentPane.add(txtTamanho);
		txtTamanho.setColumns(10);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(85, 140, 46, 14);
		contentPane.add(lblCor);

		txtCor = new JTextField();
		txtCor.setBounds(192, 139, 118, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recebendo o que foi digitado:
				String id = txtID.getText().trim();
				String nome = txtNome.getText.trim();
				String marca = txtMarca.getText.trim();
				String tamanho = txtTamanho.getText.trim();
				String cor = txtCor.getText().trim();
				String preco = txtPreco.getText.trim();
				

				Produto c = new Produto();
				
				ProdutoBD bd = new ProdutoBD(Conexao.faz_conexao());
				bd.salvar(produto);
				

				c.setID(id);
				c.setNome(nome);
				c.setMarca(marca);
				c.setTamanho(tamanho);
				c.setCor(cor);
				c.setPreco(preco);

				listaProdutos.add(c);
				JOptionPane.showMessageDialog(null, "Cadastro de Produto realizado com sucesso!");
				atualizarJTable();
				limparCampos();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(286, 227, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtNome.setText("");
				txtMarca.setText("");
				txtTamanho.setText("");
				txtCor.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(163, 227, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(42, 229, 89, 23);
		contentPane.add(btnFechar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(85, 59, 46, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(192, 58, 118, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(85, 165, 46, 14);
		contentPane.add(lblPreco);

		txtPreco = new JTextField();
		txtPreco.setBounds(192, 164, 118, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
	}
			protected void limparCampos() {
				txtID.setText("");
				txtNome.setText("");
				txtMarca.setText("");
				txtTamanho.setText("");
				txtCor.setText("");
				txtPreco.setText("");
			}
			
			protected void atualizarJTable() {
				DefaultTableModel modelo = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"ID, Nome", "Marca", "Tamanho", "Cor", "Preco"
						}
						);

			}

	}
	

