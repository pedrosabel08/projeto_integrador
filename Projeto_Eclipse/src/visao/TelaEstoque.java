package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import modelo.Produto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 
	 */
	private String ID;
	private String Nome, Marca, Tamanho, Cor;
	private String preco;
	

	/**
	 * Create the frame.
	 */
	public TelaEstoque () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItensEmEstoque = new JLabel("Itens em Estoque");
		lblItensEmEstoque.setBounds(165, 22, 122, 17);
		lblItensEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblItensEmEstoque);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 62, 330, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Marca", "Tamanho", "Cor", "Preço"
			}
		);
		//for(int i=0; i< listaProdutos.size(); i++) {
		//	Tela_Estoque c = listaProdutos.get(i);
			//modelo.addRow(new Object[] {  c.getID(), c.getNome(), c.getMarca(), c.getTamanho(), c.getCor(), c.getPreco()  });
		//}
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFechar.setBounds(21, 227, 89, 23);
		contentPane.add(btnFechar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(120, 227, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Alterar_Produto frame = new Alterar_Produto();
			//	frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(219, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManterProduto frame = new ManterProduto();
				frame.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(318, 227, 110, 23);
		contentPane.add(btnCadastrar);
	}


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	}

